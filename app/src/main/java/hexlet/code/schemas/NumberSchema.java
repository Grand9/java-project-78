package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    private boolean required = false;

    public NumberSchema() {
        addCheck("isAllowedAndEmpty", n -> !required || n != null);
    }

    public NumberSchema required() {
        required = true;
        addCheck("required", n -> n != null);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", n -> n == null || n > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", n -> n != null && n >= min && n <= max);
        return this;
    }

    @Override
    public boolean isValid(Integer number) {
        return super.isValid(number);
    }
}
