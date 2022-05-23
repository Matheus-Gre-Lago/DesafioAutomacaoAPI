package TestCases;

import BaseTests.DeletarContatoBaseTest;
import Utils.FileOperations;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DELETEContato extends DeletarContatoBaseTest {

    String id = FileOperations.getProperties("idUsuario").getProperty("id");

    @Test
    public void deleteContato(){
        given()
                .spec(requestSpec)
        .when()
                .delete(id)
        .then()
                .spec(responseSpec)
                .log().all();
    }
}
