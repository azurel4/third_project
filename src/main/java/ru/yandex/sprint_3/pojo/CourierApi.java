package ru.yandex.sprint_3.pojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import java.util.List;

import static io.restassured.RestAssured.given;


public class CourierApi {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    private static final Filter requestFilter = new RequestLoggingFilter();
    private static final Filter responseFilter = new ResponseLoggingFilter();

    public Response createCourier(Courier courier){
        return RestAssured
                .with()
                .filters(List.of(requestFilter, responseFilter))
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .and()
                .body(courier)
                .post("/courier");
    }

    public Integer loginCourier(Courier courier){
        Integer id = given()
                .with()
                .filters(requestFilter, responseFilter)
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .and()
                .body(courier)
                .post("/courier/login")
                .then().extract().body().path("id");
        return id;
    }

   /*public String getCourierId(){
        Integer id = loginCourier(courier)
                .then()
                .extract()
                .body()
                .path("id");
        return id.toString();
    }*/



    public Response deleteCourierId(Courier courier, String id){
        return RestAssured
                .with()
                .filters(List.of(requestFilter,responseFilter))
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .and()
                .body(courier)
                .delete("/courier/{id}", id);

    }


}
