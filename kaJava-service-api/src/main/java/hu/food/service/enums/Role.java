package hu.food.service.enums;

import java.util.ResourceBundle;

public enum Role {
    ADMINISTRATOR("role.administrator", "ADMINISTRATOR"), SHOPRENTER("role.shoprenter", "SHOPRENTER"), DELIVER("role.deliver", "DELIVER"), CUSTOMER("role.customer", "CUSTOMER"), GUEST("role.guest", "GUEST");

    private String name;
    private String value;

    Role(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages.Messages");
        return bundle.getString(name);
    }

    public String getValue() {
        return value;
    }
}
