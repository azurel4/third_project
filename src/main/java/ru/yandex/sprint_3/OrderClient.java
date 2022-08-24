package ru.yandex.sprint_3;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class OrderClient extends RestClient {
    private static final String ORDER_PATH = "/api/v1/orders";

    @Step("Create new order")
    public ValidatableResponse create(Order order){
        return given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }

    @Step("Create new order without POJO")
    public ValidatableResponse createWithParams(Order order){
        return given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }

}
