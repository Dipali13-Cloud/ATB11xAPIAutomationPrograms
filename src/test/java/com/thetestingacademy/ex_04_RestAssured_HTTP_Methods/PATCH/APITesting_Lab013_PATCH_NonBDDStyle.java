package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab013_PATCH_NonBDDStyle {

    @Test
    public void test_patch_non_bdd(){

        String token = "bf18e32f6890fe4";
        String bookingid = "2499";

        String payload = "{\n" +
                "    \"firstname\" : \"Diya\",\n" +
                "    \"lastname\" : \"Kumar\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" +bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().log().all().patch();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

}
