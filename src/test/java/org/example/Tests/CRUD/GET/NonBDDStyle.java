package org.example.Tests.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    public static void main(String[] args) {
        //url:https://restful-booker.herokuapp.com/booking/125
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/125").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }
}
