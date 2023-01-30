package userinfo;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String email;
    private String password;

    public User() {
        this.email = userEmail();
        this.password = userPassword();
        this.name = userName();
    }

    public static String userName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String userEmail() {
        return RandomStringUtils.randomAlphanumeric(10) + "@test.test";
    }

    public static String userPassword() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String userIncorrectPassword() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
