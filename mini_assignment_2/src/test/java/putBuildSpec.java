import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class putBuildSpec {
    RequestSpecification reqspec;
    ResponseSpecification reponspec;
    @BeforeTest
    public void setup(){
        RequestSpecBuilder reqspecbuild=new RequestSpecBuilder();
        reqspecbuild.setBaseUri("https://reqres.in/api").
                addHeader("Content-Type","application/json");
        reqspec= RestAssured.with().spec(reqspecbuild.build());
        reponspec=RestAssured.expect().contentType(ContentType.JSON);
    }
    @Test
    public void putCall(){
        RestAssured.useRelaxedHTTPSValidation();
        File jsonData = new File("C:\\Users\\pyogeshbhai\\Documents\\HU_API_Testing\\mini_assignment_2\\src\\test\\resources\\putdata.json");
        given().
                spec(reqspec).
                body(jsonData).
                when().
                put("/users").
                then().
                spec(reponspec).statusCode(200);
    }
}