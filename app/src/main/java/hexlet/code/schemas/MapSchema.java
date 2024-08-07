package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, Object>> {

    private boolean required = false;
    private Map<String, BaseSchema<String>> shapeSchemas = new HashMap<>();

    public MapSchema() {
        addCheck("isAllowedAndEmpty", map -> !required || map != null);
    }

    public MapSchema required() {
        required = true;
        addCheck("required", map -> map != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", map -> map != null && map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        shapeSchemas = schemas;
        addCheck("shape", map -> {
            if (map == null) {
                return false;
            }
            for (Map.Entry<String, BaseSchema<String>> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> schema = entry.getValue();
                Object value = map.get(key);
                if (value == null || !schema.isValid((String) value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
