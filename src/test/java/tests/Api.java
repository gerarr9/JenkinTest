package tests;

import api.dto.games.User;
import fabric.UserFabric;
import api.specification.RequestSpec;
import extensions.RestExtensions;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RestExtensions.class)
public class Api {

    @Test
    public void createUser() {
        User user = UserFabric.createDefaultUser();
        System.out.println(user);

        User createUser = RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .body(user)
                .post("api/signup")
                .then().log().all()
                .statusCode(201)
                .extract().as(User.class);

        System.out.println(createUser);
    }
}
