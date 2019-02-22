package Get_Post_Put_Delete;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.Random;

public class Practice_Get_Post_Put_Delete_1 {

    @Test

    public void testGet(){
        RestAssured.baseURI="http://localhost:3000";

        given().contentType("application/json")
                .when().get("/posts/1")
                .then().log().all();
    }


    @Test
    public void testPost(){

        JSONObject json=new JSONObject();
        int randomid =new Random().nextInt(1000);

        json.put("id",randomid);
        json.put("title","Salma-server-4"+randomid);
        json.put("author","Neer"+randomid);


        RestAssured.baseURI="http://localhost:3000";

        given().header("Content-Type","application/json")
                .body(json.toJSONString())

          .when()
              .post("/posts")
              .then()
                    .statusCode(201)
                    .and()
                    .log().all();
    }

    @Test
    public void testPut(){

        JSONObject json=new JSONObject();
        int randomid =new Random().nextInt(1000);

        json.put("id",randomid);
        json.put("title","Salma-server-4"+randomid);
        json.put("author","Azam"+randomid);



        RestAssured.baseURI="http://localhost:3000";

        given()
                .header("Content-Type","application/json")
                .body(json.toJSONString())
                .when()
                .put("/posts/48")
                .then()
                .statusCode(200)
                .and()
                .log().all();
    }
    @Test
    public void testDelete(){

        RestAssured.baseURI="http://localhost:3000";

        given()
                .header("Content-Type","application/json")
                .when()
                .delete("/posts/993")
                .then()
                .statusCode(200)
                .log().all();

    }

}
