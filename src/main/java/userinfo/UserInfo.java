package userinfo;

import org.apache.commons.lang3.RandomStringUtils;

public class UserInfo {
    public final String nameForLogin = "Andrew";
    public final String emailForLogin = "andrewmail@test.test";
    public final String passwordForLogin = "testpassword";
    public final String nameForRegistration = RandomStringUtils.randomAlphabetic(10);
    public final String emailForRegistration = RandomStringUtils.randomAlphanumeric(8) + "@test.test";
    public final String passwordForRegistration = "qwerty123";
    public final String passwordForIncorrectRegistration = "wasd1";
}
