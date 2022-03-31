import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class putCallMiniAssignment1 {

    @Test
    public void putCall(){
        File JsonData=new File("src\\test\\resources\\putcall.json");
        given().
                baseUri("https://reqres.in/api/users").
                body(JsonData).
                header("Content-Type","application/json").
                when().
                put("/users").
                then().
                statusCode(200).body("name",equalTo("Arun")).body("job",equalTo("Manager"));

    }
    }



