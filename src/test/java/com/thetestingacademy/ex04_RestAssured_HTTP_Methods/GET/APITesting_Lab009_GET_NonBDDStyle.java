package com.thetestingacademy.ex04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab009_GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_NonBDD() {

        String pin_code = "560066";

        // GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/" + pin_code);

        // WHEN
        response = r.when().log().all().get();
        System.out.println(response.asString());

        // THEN
        vr = response.then().log().all();
        vr.statusCode(200);

    }

    @Test
    public void test_GET_NonBDD_Negative() {

        String pin_code = "@";

        // GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/" + pin_code);

        // WHEN
        response = r.when().log().all().get();
        System.out.println(response.asString());

        // THEN
        vr = response.then().log().all();
        vr.statusCode(404);

    }
}
