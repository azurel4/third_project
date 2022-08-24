/*package ru.yandex.sprint_3;

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
    @Test
    public void courierCanBeCreated(){
        ValidatableResponse response = courierClient.create(courier);
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect", 201, statusCode);

        ValidatableResponse responseWrongLogin = courierClient.login(CourierCredentials.loginFrom(courier));
        courierId = responseWrongLogin.extract().path("id");
        System.out.println(courierId);

        String wrongLoginMessage = responseWrongLogin.extract().path("message");
        System.out.println(wrongLoginMessage);

    }

}*/

