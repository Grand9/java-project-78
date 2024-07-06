package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * BaseSchema is an abstract class that provides a foundation for creating validation schemas.
 * Extend this class to add custom validation checks or behaviors.
 *
 * @param <T> the type of value to be validated
 */
public abstract class BaseSchema<T> {

    private final Map<String, Predicate<T>> checks = new HashMap<>();

    /**
     * Adds a validation check with a given name and predicate.
     * Override this method to customize validation checks.
     *
     * @param name      the name of the check
     * @param predicate the predicate function for the check
     */
    public void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    /**
     * Validates if the given value passes all registered checks.
     * Override this method to customize validation logic.
     *
     * @param value the value to be validated
     * @return true if the value is valid; false otherwise
     */

    @SuppressWarnings("unchecked")
    public boolean isValid(Object value) {
        return checks.values().stream().allMatch(check -> check.test((T) value));
    }
}
