package TestCases;

import BaseTests.EditarContatoBaseTest;
import Utils.FileOperations;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PUTEditaContato extends EditarContatoBaseTest {
    String id = FileOperations.getProperties("idUsuario").getProperty("id");

    @Test
    public void putEditaContato(){
        given()
                .spec(requestSpec)
                .log().all()
        .when()
                .put(id)
        .then()
                .spec(responseSpec)
                .log().all();
     }
}
