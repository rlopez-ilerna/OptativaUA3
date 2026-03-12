package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TitleRulesTest {
    @Test
    void Prueba() {
        assertEquals("COMPLETADA", "COMPLETADA");
    }

    @Test
    void normalizeTitle_recortaYReduceEspacios(){
        String Resultado = TitleRules.normalizeTitle("Hola  mundo");
        assertEquals("Hola mundo", Resultado);
    }

    @Test
    void validateTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            TitleRules.validateTitle(" ");
        });
    }

    @Test
    void validateTitle_fallaSiDemasiadoLargo(){
        assertThrows(IllegalArgumentException.class, () -> {
            TitleRules.validateTitle("kt5X372vEdjxEtFquAN5cubAcceUW6XXNCubQwbfNAxDPbvN0Etm7GWJWG3du");
        });
    }

    @Test
    void validateTitle_okSiCorrecto(){
        TitleRules.validateTitle("Titulito");
    }
}
