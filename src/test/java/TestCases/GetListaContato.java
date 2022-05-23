package TestCases;

import BaseTests.ListaContatoBaseTest;
import Utils.FileOperations;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GetListaContato extends ListaContatoBaseTest {



    @Test
    public void getListaContato(){
    String id = FileOperations.getProperties("idUsuario").getProperty("id");
      Response response =
              given()
                     .spec(requestSpec)
              .when()
                     .get(id)
              .then()
                     .spec(responseSpec)
                     .log().all()
                     .extract().response();

        String name =
                given()
                        .spec(requestSpec)
                .when()
                        .get(id)
                .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().path("data.attributes.name");

        String phone =
                given()
                        .spec(requestSpec)
                .when()
                        .get(id)
                .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().path("data.attributes.phone");
        String email =
                given()
                        .spec(requestSpec)
                .when()
                        .get(id)
                .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().path("data.attributes.email");

      assertEquals(FileOperations.getProperties("userData").getProperty("name") , name);
      assertEquals(FileOperations.getProperties("userData").getProperty("phone") , phone);
      assertEquals(FileOperations.getProperties("userData").getProperty("email") , email);
    }
}
