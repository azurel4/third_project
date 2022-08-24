package ru.yandex.sprint_3;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourierCreateWithoutValidFieldTest {

    private Courier courier;
    private CourierClient courierClient;

    @Before
    public void setUp(){
        courier = CourierGenerator.getWithoutOneValidField();
        courierClient = new CourierClient();
    }

    @Test
    public void courierWithoutValidFieldCantBeCratedTest(){
        ValidatableResponse response = courierClient.create(courier);

        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect",  400, statusCode);

        String message = response.extract().path("message");
        assertEquals("Wrong message", "Недостаточно данных для создания учетной записи", message);
    }
}

