package ru.yandex.sprint_3;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.sprint_3.pojo.CourierApi;
import ru.yandex.sprint_3.pojo.Courier;


public class TestCreateAndDeleteCourier {
    private CourierApi client;
    String login = "akuna";
    String password = "matata";
    String firstName = "Pumba";
    Courier courier = new Courier(login, password, firstName);
    Courier courierForLogin = new Courier(login, password);

    @Before
    public void setUp() throws Exception{
        client = new CourierApi();
        final Courier courier = new Courier(login, password, firstName);
    }


    @Test
    @DisplayName("Проверка создания курьера со всеми полями")
    public void validCreateCourierShouldReturnStatus_201_ok(){
        boolean response = client.createCourier(courier)
                .then()
                .statusCode(201)
                .extract().body().path("ok");
        Assert.assertTrue(response);
    }


    @Test
    @DisplayName("Проверка удаления курьера")
    public void deleteCourierIdShouldReturnStatus_200_ok(){
        Integer response = client.loginCourier(courierForLogin);
        boolean actualResponseDeleteCourier = client.deleteCourierId(courierForLogin, String.valueOf(response))
                .then()
                .statusCode(200)
                .extract().body().path("ok");
        Assert.assertTrue(actualResponseDeleteCourier);

    }
}