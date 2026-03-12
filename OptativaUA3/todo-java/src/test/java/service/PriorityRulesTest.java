package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriorityRulesTest {
    @Test
    void parsePriority_ok_minimoYmaximo(){
        assertEquals(1, PriorityRules.parsePriority("1"));
        assertEquals(5, PriorityRules.parsePriority("5"));
    }

    @Test
    void parsePriority_falla_siNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityRules.parsePriority(null);
        });
    }

    @Test
    void parsePriority_falla_siNoNumero(){
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityRules.parsePriority("abc");
        });
    }

    @Test
    void parsePriority_falla_fueraDeRango(){
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityRules.parsePriority("0");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityRules.parsePriority("6");
        });
    }

    @Test
    void validatePriority_okYerror(){
        PriorityRules.validatePriority(3);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            PriorityRules.validatePriority(0);
        });
        assertEquals("priority_out_of_range", e.getMessage());
    }
}
