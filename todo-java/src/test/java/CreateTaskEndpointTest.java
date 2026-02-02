import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTaskEndpointTest {
    @Test
    void post_tasks_devuelve201_y_campos_basicos() throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = """
        {
        "title": "Comprar pan",
        "priority": 3,
        "tags": ["casa"]
        }
        """;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/tasks/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());

        assertEquals(201, response.statusCode());
        assertTrue(response.body().contains("\"title\":\"Comprar pan\""));
        assertTrue(response.body().contains("\"priority\":3"));
        assertTrue(response.body().contains("\"done\":false"));
        assertTrue(response.body().matches(".*\"id\":\\d+.*"));
    }
}
