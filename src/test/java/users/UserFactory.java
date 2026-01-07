package users;

import utils.PropertyReader;

public record UserFactory() {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }
}
