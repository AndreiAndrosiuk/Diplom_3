package userinfo;

import config.BaseClient;
import config.Configuration;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {

    private static final String ROOT = "/auth";
    private static final String REGISTER = ROOT + "/register";
    private static final String AUTHORIZATION = ROOT + "/login";
    private static final String USER = ROOT + "/user";

    public ValidatableResponse createUser(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(REGISTER)
                .then().log().all();
    }

    public void deleteUser(String accessToken) {
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(Configuration.BASE_URL)
                .delete(USER)
                .then().log().all();
    }

    public ValidatableResponse login(User user) {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(Configuration.BASE_URL)
                .body(user)
                .post(AUTHORIZATION)
                .then().log().all();
    }
}
