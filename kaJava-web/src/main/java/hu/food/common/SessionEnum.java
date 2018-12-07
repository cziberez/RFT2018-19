package hu.food.common;

public enum SessionEnum {

    LOGINSTATE("loginState", "false");

    private String name;

    private String defaultValue;

    SessionEnum(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return defaultValue;
    }
}
