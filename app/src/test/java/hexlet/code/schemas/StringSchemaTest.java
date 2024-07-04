package hexlet.code.schemas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    void setUp() {
        schema = new StringSchema();
    }

    @Test
    void minLengthValid() {
        schema.minLength(3);
        assertTrue(schema.isValid("abc"));
    }

    @Test
    void minLengthInvalid() {
        schema.minLength(5);
        assertFalse(schema.isValid("abc"));
    }

    @Test
    void containsValid() {
        schema.contains("abc");
        assertTrue(schema.isValid("defabcghi"));
    }

    @Test
    void containsInvalid() {
        schema.contains("abc");
        assertFalse(schema.isValid("defghijk"));
    }

    @Test
    void requiredValid() {
        schema.required();
        assertTrue(schema.isValid("abc"));
    }

    @Test
    void requiredNullInvalid() {
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void requiredEmptyInvalid() {
        schema.required();
        assertFalse(schema.isValid(""));
    }
}
