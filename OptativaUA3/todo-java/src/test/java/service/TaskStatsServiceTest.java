package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskStatsServiceTest {
    @Test
    void doneRatio_devuelveCero_siNull(){
        TaskStatsService t1 = new TaskStatsService();
        assertEquals(0.0, t1.doneRatio(null));
    }

    @Test
    void doneCount_devuelveCero_siNull(){
        TaskStatsService t1 = new TaskStatsService();
        assertEquals(0, t1.doneCount(null));
    }

}