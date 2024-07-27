package org.example.Tests.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPatchCookie {
    @Test
    public void TestPatchpositive(){
        String Payload="{\n" +
                "    \"firstname\" : \"John\",\n" +
                "    \"lastname\" : \"Brat\"\n" +
                "}";
        String token="0053a9d8d0299c4";
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/980");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(Payload);
        Response response=r.patch();
        System.out.println(response);
        ValidatableResponse v= response.then().log().all();
        v.statusCode(200);
        v.body("firstname", Matchers.equalTo("John"));
        v.body("lastname", Matchers.equalTo("Brat"));

    }
}
