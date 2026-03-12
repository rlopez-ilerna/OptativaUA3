package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TagRulesTest {
    @Test
    void normalizeTag_ok_minimo(){
        assertEquals("casa", TagRules.normalizeTag("casa"));
    }

    @Test
    void normalizeTag_ok_recortaYMinusculas(){
        assertEquals("casa", TagRules.normalizeTag("CaSa"));
    }

    @Test
    void normalizeTag_fallaSiNull(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            TagRules.normalizeTag(null);
        });
        assertEquals("tag_null", e.getMessage());
    }

    @Test
    void normalizeTag_fallaSiVacio(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            TagRules.normalizeTag(" ");
        });
        assertEquals("tag_empty", e.getMessage());
    }

    @Test
    void normalizeTag_fallaSiDemasiadoLargo(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            TagRules.normalizeTag("kqx99abvkKDgzbutjqSkwaVRWYWE1Q2");
        });
        assertEquals("tag_too_long", e.getMessage());
    }

    @Test
    void normalizeTag_fallaSiCaracteresInvalidos(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            TagRules.normalizeTag("hola!");
        });
        assertEquals("tag_invalid_chars", e.getMessage());
    }
}
