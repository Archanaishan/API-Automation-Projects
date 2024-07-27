package org.example.Tests.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDeleteCookie {
    @Test
    public void TestDeletepositive(){
        String token="7c5415be1001969";
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2364");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        Response response=r.delete();
        System.out.println(response);
        ValidatableResponse v= response.then().log().all();
        v.statusCode(201);
            }
}
