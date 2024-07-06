package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    /**
     * Creates and returns a new instance of StringSchema for validating strings.
     *
     * @return StringSchema instance for string validation.
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates and returns a new instance of NumberSchema for validating numbers.
     *
     * @return NumberSchema instance for number validation.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates and returns a new instance of MapSchema for validating maps.
     *
     * @return MapSchema instance for map validation.
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
