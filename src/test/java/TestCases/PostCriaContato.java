package TestCases;

import BaseTests.CriarContatoBaseTest;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostCriaContato extends CriarContatoBaseTest {

    @Test
    public void postCriaContato(){
        Response payload =
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .post()
        .then()
                .spec(responseSpec)
                .log().all()
                .extract().response();

        String id = payload.then().extract().path("data.id");

        FileOperations.setProperties("idUsuario" , "id" , id);
    }
}
