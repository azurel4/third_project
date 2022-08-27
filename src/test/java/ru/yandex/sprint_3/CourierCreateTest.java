package ru.yandex.sprint_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierCreateTest {

    private Courier courier;
    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp() {
        courier = CourierGenerator.getDefault();
        courierClient = new CourierClient();
    }

    @After
    public void tearDown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Создание курьера")
    @Description("Проверка статуса 200, тела сообщения и id")
    public void courierCanBeCreatedTest() {
        ValidatableResponse response = courierClient.create(courier);

        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect", 201, statusCode);

        boolean isCreated = response.extract().path("ok");
        assertTrue("Courier is not created", isCreated);

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        int loginStatusCode = loginResponse.extract().statusCode();
        assertEquals("Status code is incorrect", 200, loginStatusCode);

        courierId = loginResponse.extract().path("id");
        assert (courierId > 0);
    }

    @Test
    @DisplayName("Создание двух одинаковых курьеров не возможно")
    @Description("Проверка статуса 409 и сообщения")
    public void twoIdenticalCourierCantBeCreatedTest() {
        ValidatableResponse response = courierClient.create(courier);
        boolean isCreated = response.extract().path("ok");

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");
        assert (courierId > 0);

        ValidatableResponse secondResponse = courierClient.create(courier);

        int statusCode = secondResponse.extract().statusCode();
        assertEquals("Status code is incorrect", 409, statusCode);

        String message = secondResponse.extract().path("message");
        assertEquals("Wrong message", "Этот логин уже используется. Попробуйте другой.", message);
    }
}