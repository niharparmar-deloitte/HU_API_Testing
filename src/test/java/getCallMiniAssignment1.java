import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getCallMiniAssignment1 {
    @Test
    public void getResponse(){
                    given().
                         header("Content-Type","application/json").
                    when().
                        get("https://jsonplaceholder.typicode.com/posts").
                    then().
                        body("userId[39]",equalTo(4)).
                            body("title[39]",equalTo("enim quo cumque")).
                        statusCode(200);
    }
}
