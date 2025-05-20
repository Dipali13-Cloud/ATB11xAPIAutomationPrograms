package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_NonBDD {
    @Test
    public void test_patch_non_bdd(){

        String token = "d5f3634300a8f7d";
        String bookingid = "3014";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" +bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.log().all();

        Response response = requestSpecification.when().log().all().delete();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}
