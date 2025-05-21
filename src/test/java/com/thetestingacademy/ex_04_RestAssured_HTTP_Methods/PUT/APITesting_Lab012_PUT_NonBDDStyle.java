package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab012_PUT_NonBDDStyle {
    // PUT

    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}

    RequestSpecification r;
    Response res;
    ValidatableResponse vr;

    @Test
    public void  test_put_non_bdd(){

        String token = "bf18e32f6890fe4";
        String bookingid = "2499";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Deepa\",\n" +
                "    \"lastname\" : \"Kunwar\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        // r.auth().
        r.cookie("token", token);
        r.body(payloadPUT).log().all();

        res = r.when().log().all().put();

        vr = res.then().log().all();
        vr.statusCode(200);

    }
}
