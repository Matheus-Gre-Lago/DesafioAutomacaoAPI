package BaseTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static BaseTests.Endpoints.CONTATOS;

public class DeletarContatoBaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setUp(){
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath(CONTATOS)
                .addHeader("Content-Type" , "application/json")
                .build();
    }

    public  static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
