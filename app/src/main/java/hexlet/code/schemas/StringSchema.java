package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    private boolean required = false;

    public StringSchema() {
        addCheck("isAllowedAndEmpty", s -> !required || (s != null && !s.isEmpty()));
    }

    public StringSchema minLength(int lengthOfString) {
        addCheck("minLength", s -> s.length() >= lengthOfString);
        return this;
    }

    public StringSchema contains(String restriction) {
        addCheck("contains", s -> s.contains(restriction));
        return this;
    }

    public StringSchema required() {
        required = true;
        addCheck("required", s -> s != null && !s.isEmpty());
        return this;
    }
}
