package ru.yandex.sprint_3;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class ParamsPlaceOrderTest {

    private final String[] color;

    public ParamsPlaceOrderTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getColor() {
        return new Object[][]{
                {new String[]{"GRAY", "BLACK"}},
                {new String[]{"GRAY"}},
                {new String[]{"BLACK"}},
                {new String[]{}}
        };

    }

    @Test
    @DisplayName("Создание заказа")
    @Description("Проверка всех возможных вариантов BLACK, GREY, оба цвета, без цвета и проверка что тело содержит track")
    public void createOrderTest() {
        Order order = new Order("hdhdj", "jhjj", "90987777", "60", "2022-09-29", "hhhh", color, "jhuu", "hjjn");
        OrderClient orderClient = new OrderClient();
        ValidatableResponse response = orderClient.create(order);

        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect", 201, statusCode);

        int track = response.extract().path("track");
        assert (track > 0);
    }

}
