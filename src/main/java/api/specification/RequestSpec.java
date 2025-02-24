package api.specification;

import config.ConfigData;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigData.BASE_URL.getValue())
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
}
