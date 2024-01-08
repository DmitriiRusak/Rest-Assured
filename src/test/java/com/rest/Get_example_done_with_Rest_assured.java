package com.rest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
//Example of Get method
// In this example we are trying to get the same result, as in Postman
// I provided the bse url, header (wich somoe sort of a key for postman API), end point (/workspaces).

//Notice that instruction log().all() stands not at the end of a program but first in then() block. This gives
//us output even if error acquired.

//Method body - включает в себя 2 аргумента: первый это как бы groovy запрос,  второй аргумент это ожидаемый
//нами результат. Метод выполнит инструкцию описанную Groovy языком и сравнит полученный результат с ожидаемым.
// Это чтото типа ассерта в testNG.
public class Get_example_done_with_Rest_assured {

  @org.testng.annotations.Test
    public void validate_getStatusCode(){
      given().
              baseUri("https://api.postman.com").
              header("X-Api-key", "PMAK-6585942c8013554e461c01b3-8411badf1a5bce78ea2f5d68d39740916d").
      when().
              get("/workspaces").
      then().
              log().all().
              assertThat().
              statusCode(200).
              body("workspaces.name",hasItems("First_Workspace", "Om_Pracash_Tutorial"),
                      "workspaces.type",hasItems("personal", "personal"),
                      "workspaces[0].name", equalTo("First_Workspace"),
                      "workspaces.size", equalTo(3));
    }
}
