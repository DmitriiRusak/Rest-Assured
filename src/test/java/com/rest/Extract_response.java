package com.rest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// We are creating variable of type Response, and then we can use these variable to further process.
// For example lets print it using: System.out.println(response.asString());
// It will print the string, not a beautify result but mere string, then we need to use JSON Path finder.
// I use: https://jsonpathfinder.com/

//response.path("groovy.path") <-- returns the single field from the JSON response
//For the same porpose we can use JsonPath class to create an object of it. For that we need to pass response
//object. Once we created JsonPath object we can call appropriate method get if we want to get any field
//from the JSON, the only one thing that we need to know is what type is the field, we want to get.


public class Extract_response {


    @org.testng.annotations.Test
    public void validate_getStatusCode(){
        Response response = given().
                baseUri("https://api.postman.com").
                header("X-Api-key", "PMAK-6585942c8013554e461c01b3-8411badf1a5bce78ea2f5d68d39740916d").
            when().
                get("/workspaces").
            then().
                assertThat().
                statusCode(200).
                extract().response();
                System.out.println(response.asString());

//estracting single field
        JsonPath jsonPath = new JsonPath(response.asString());
                System.out.println("id: "+(String) jsonPath.get("workspaces[0].id"));
                System.out.println("response name: "+(String) response.path("workspaces[0].name"));
                JsonPath.from()
    }
}
