package BaseTests;

import Models.ContatoModel;
import Utils.FakerGenerator;
import Utils.FileOperations;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class CriarContatoBaseTest extends Endpoints{

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static ContatoModel contatoModel;

    @BeforeClass
    public static void setUp(){
        buildPojoObject();
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec(){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath(CONTATOS)
                .addHeader("Content-Type" , "application/json")
                .setBody(contatoModel)
                .build();
    }

    public  static void buildResponseSpec(){
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void buildPojoObject(){
        contatoModel = new ContatoModel(
                FakerGenerator.getName(),
                FakerGenerator.getLasName(),
                FakerGenerator.getEmail(),
                FakerGenerator.getAge(),
                FakerGenerator.getPhone(),
                FakerGenerator.getAddress(),
                FakerGenerator.getState(),
                FakerGenerator.getACity()
        );
        salvarDados(contatoModel);
    }

    public static void salvarDados(ContatoModel contatoModel){
        FileOperations.setProperties("userData" , "name" , contatoModel.getName());
        FileOperations.setProperties("userData" , "last_name" , contatoModel.getLastName());
        FileOperations.setProperties("userData" , "email" , contatoModel.getEmail());
        FileOperations.setProperties("userData" , "age" , contatoModel.getAge());
        FileOperations.setProperties("userData" , "phone" , contatoModel.getPhone());
        FileOperations.setProperties("userData" , "address" , contatoModel.getAddress());
        FileOperations.setProperties("userData" , "state" , contatoModel.getState());
        FileOperations.setProperties("userData" , "city" , contatoModel.getCity());
    }
}
