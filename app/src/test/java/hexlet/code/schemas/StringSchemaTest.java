package hexlet.code.schemas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    void setUp() {
        schema = new StringSchema();
    }

    @Test
    void minLength_valid() {
        schema.minLength(3);
        assertTrue(schema.isValid("abc"));
    }

    @Test
    void minLength_invalid() {
        schema.minLength(5);
        assertFalse(schema.isValid("abc"));
    }

    @Test
    void contains_valid() {
        schema.contains("abc");
        assertTrue(schema.isValid("defabcghi"));
    }

    @Test
    void contains_invalid() {
        schema.contains("abc");
        assertFalse(schema.isValid("defghijk"));
    }

    @Test
    void required_valid() {
        schema.required();
        assertTrue(schema.isValid("abc"));
    }

    @Test
    void required_null_invalid() {
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void required_empty_invalid() {
        schema.required();
        assertFalse(schema.isValid(""));
    }
}