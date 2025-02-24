package api.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public static ResponseSpecification responseSpecification(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }
}
