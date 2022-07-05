import io.restassured.RestAssured;
import org.junit.*;
import ru.yandex.sprint_3.Courier;
import static io.restassured.RestAssured.given;


public class Api_courier {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void checkCreateCourier(){
        Courier courier = new Courier("akunamatata", "pumba", "Василий");
        boolean actualResponseCreateCourier = given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then().statusCode(201)
                .extract().body().path("ok");
        Assert.assertTrue(actualResponseCreateCourier);
    }
    @AfterClass
    public static void deleteCourier(){
        Courier courier = new Courier("akunamatata", "pumba");
        int id = given()
                .header("Content-type","application/json")
                .and().body(courier).when()
                .post("/api/v1/courier/login")
                .then().extract().body().path("id");

        boolean actualResponseDeleteCourier = given()
                .header("Content-type","application/json")
                .and().body(courier).when()
                .delete("/api/v1/courier/{id}", id)
                .then()
                .statusCode(200)
                .extract().body().path("ok");
        Assert.assertTrue(actualResponseDeleteCourier);

    }


}
