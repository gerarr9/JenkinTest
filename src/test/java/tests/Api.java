package tests;

import Fabric.UserFabric;
import api.dto.games.Game;
import api.dto.games.User;
import api.specification.RequestSpec;
import extensions.RestExtensions;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(RestExtensions.class)
public class Api {

    @Test
    public void first() {
        User user = UserFabric.createDefaultUser();
        System.out.println(user);

        User createUser = RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .body(user)
                .post("api/signup")
                .then().log().all()
                .statusCode(200)
                .extract().as(User.class);

        System.out.println(createUser);
    }
}
