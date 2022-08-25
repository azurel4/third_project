package ru.yandex.sprint_3;
import static org.junit.Assert.*;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class GetOrdersTest {

    @Test
    public void getAllOrdersTest(){
        OrderClient orderClient = new OrderClient();
        ValidatableResponse response = orderClient.get();
        int statusCode = response.extract().statusCode();
        assertEquals("Status code is incorrect", 200, statusCode);
        String responseOrder = String.valueOf(response.extract().body());
        responseOrder.contains("orders");
    }

}
