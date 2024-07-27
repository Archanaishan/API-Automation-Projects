package org.example.Tests.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDAuth {
    @Test
    public void TestPutpositive(){
        String Payload="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        String token="06c3bd48ff78346";
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1318");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(Payload);
        Response response=r.put();
        System.out.println(response);
        ValidatableResponse v= response.then().log().all();
        v.statusCode(200);
        v.body("firstname", Matchers.equalTo("James"));
        v.body("lastname", Matchers.equalTo("Brown"));
    }
}
