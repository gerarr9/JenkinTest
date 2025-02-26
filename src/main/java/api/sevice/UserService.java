package api.sevice;

import api.dto.games.Authorization;
import api.dto.games.User;
import api.specification.RequestSpec;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private static final String API_USER = "api/user";

    private static String token;

    @Step("Создание юзера")
    public static void createUser(User user) {
        RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .body(user)
                .post("api/signup")
                .then().log().body()
                .statusCode(201)
                .extract().as(User.class);
    }
    @Step("Получение списка последних 100 созданных юзеров")
    public static List<String> getListUser() {
        return RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .get("api/users")
                .then().log().body()
                .extract().as(new TypeRef<List<String>>() {
                });
    }
    @Step("Авторизация")
    public static void authorization(Authorization authorization) {

        token = RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .body(authorization)
                .post("api/login")
                .then().log().body()
                .statusCode(200)
                .extract()
                .path("token");
    }
    @Step("Изменение пароля")
    public static void ChangePass(String newPass) {
        Map<String, String> pass = new HashMap<>(Map.of("password", newPass));
        RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .header("Authorization", "Bearer " + token)
                .body(pass)
                .put(API_USER)
                .then().log().all()
                .statusCode(200);
    }
    @Step("Удаление пользователя")
    public static void deleteUser() {
        RestAssured.given()
                .spec(RequestSpec.requestSpecification())
                .header("Authorization", "Bearer " + token)
                .delete(API_USER)
                .then().log().all()
                .statusCode(200);
    }

}
