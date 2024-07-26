package org.example.Tests.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyle {
    public static void main(String[] args) {
        //baseurl:http://api.zippopotam.us
        //basepath:/IN/626125
        RestAssured
                .given()
                .baseUri("http://api.zippopotam.us")
                .basePath("/IN/560037")
                .when()
                .get()
                .then().statusCode(200);
    }
}
