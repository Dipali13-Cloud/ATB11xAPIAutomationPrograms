package com.thetestingacademy.ex_07_Payload_management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class APITesting030_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {


        //        String payload = "{\n" +
        //                "    \"firstname\" : \"Dipali\",\n" +
        //                "    \"lastname\" : \"Kunwar\",\n" +
        //                "    \"totalprice\" : 111,\n" +
        //                "    \"depositpaid\" : true,\n" +
        //                "    \"bookingdates\" : {\n" +
        //                "        \"checkin\" : \"2018-01-01\",\n" +
        //                "        \"checkout\" : \"2019-01-01\"\n" +
        //                "    },\n" +
        //                "    \"additionalneeds\" : \"Breakfast\"\n" +
        //                "}";


        // Hashmap -> Key and Value
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Dipali");
        jsonBodyUsingMap.put("lastname", "Kunwar");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", false);

        Map<String,Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);

        // Convert Hashmap ->  json ->
        // 1. gson
        //  2. jackson API

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Dipali"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Kunwar"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
        validatableResponse.body("bookingid", Matchers.notNullValue());




    }
}
