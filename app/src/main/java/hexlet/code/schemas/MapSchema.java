package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, ?>> {

    private boolean required = false;

    public MapSchema() {
        addCheck("isAllowedAndEmpty", map -> !required || (map != null));
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

}
