package Get_Post_Put_Delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Practice_Get_Post_Put_Delete_2 {
@Test
    public void testGet(){

        Response resp=RestAssured.get("http://localhost:3000/posts");

       int code=resp.getStatusCode();

        Assert.assertEquals(code,200);

}
    @Test
    public void testPost(){
        RequestSpecification request=RestAssured.given();

        request.header("Content-Type","application/json");

        JSONObject json=new JSONObject();

        int randomid=new Random().nextInt(2000);
        json.put("id",randomid);
        json.put("title","Salma-server-5"+randomid);
        json.put("author", "Spondhon"+randomid);

        request.body(json.toJSONString());

        Response response= request.post("http://localhost:3000/posts");

        int code=response.getStatusCode();
        Assert.assertEquals(code,201);


    }


    @Test
    public void testPut(){
        RequestSpecification request= RestAssured.given();

        request.header("Content-Type","application/json");
        JSONObject json=new JSONObject();
        int randomid=new Random().nextInt(2000);
        json.put("id",randomid);
        json.put("title","Salma-server-5"+randomid);
        json.put("author", "tanjum"+randomid);

        request.body(json.toJSONString());

        Response response= request.put("http://localhost:3000/posts/1499");

        int code=response.getStatusCode();
        Assert.assertEquals(code,200);


    }
    @Test
    public void testDelete(){
        RequestSpecification request= RestAssured.given();


        Response response= request.delete("http://localhost:3000/posts/1499");

        int code=response.getStatusCode();
        Assert.assertEquals(code,200);


    }
}
