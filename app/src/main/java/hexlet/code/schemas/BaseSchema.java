package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private final Map<String, Predicate<T>> checks = new HashMap<>();

    public void addCheck(String name, Predicate<T> predicate) {
        checks.put(name, predicate);
    }

    public boolean isValid(Object value) {
        return checks.values().stream().allMatch(check -> check.test((T) value));
    }
}
