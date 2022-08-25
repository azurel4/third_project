/*package ru.yandex.sprint_3;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierLoginWithoutValidField {

    private Courier courier;
    private Courier courierForLogin;
    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp(){
        courierForLogin = CourierGenerator.getWithoutTwoValidFields();
        courier = CourierGenerator.getDefault();
        courierClient = new CourierClient();
    }

    @After
    public void tearDown(){
        courierClient.delete(courierId);
    }

    @Test
    public void courierCantBeCreated(){
        ValidatableResponse response = courierClient.create(courier); //создаю курьера
        int statusCode = response.extract().statusCode();
        //assertEquals("Status code is incorrect", 201, statusCode);

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier)); //логин курьера для получения id, чтобы удалить в конце теста
        int loginStatusCode = loginResponse.extract().statusCode();
        assertEquals("Status code is incorrect", 200, loginStatusCode);

        courierId = loginResponse.extract().path("id");
        assert(courierId > 0);

        CourierCredentials.loginFrom(courierForLogin);
        ValidatableResponse responseWrongLogin = courierClient.login(); //логин курьера только с одним полем

        String wrongLoginMessage = responseWrongLogin.extract().path("message");
        System.out.println(wrongLoginMessage);

    }

}*/

