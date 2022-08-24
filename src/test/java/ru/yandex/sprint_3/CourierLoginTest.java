package ru.yandex.sprint_3;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourierLoginTest {

    private Courier courier;
    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp() {
        courier = CourierGenerator.getDefault();
        courierClient = new CourierClient();
    }

    @After
    public void tearDown(){
        courierClient.delete(courierId);
    }

    @Test
    public  void courierCanLoginTest(){
        ValidatableResponse response = courierClient.create(courier);

        //int statusCode = response.extract().statusCode();

        //boolean isCreated = response.extract().path("ok");

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        int loginStatusCode = loginResponse.extract().statusCode();
        assertEquals("Status code is incorrect", 200, loginStatusCode);

        courierId = loginResponse.extract().path("id");
        assert(courierId > 0);
    }
}
