package com.thetestingacademy.ex_06_TestAssetions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting026_RestAsssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;


    @Owner("Dipali")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the create booking is working fine, booking ID is not null")
    @Test
    public void test_createBooking_POST(){
        // String Payload
        String payload = "{\n" +
                "    \"firstname\" : \"Dipali\",\n" +
                "    \"lastname\" : \"Kunwar\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().log().all().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured
        validatableResponse.statusCode(200);

        // Firstname == Dipali , Lastname = Kunwar
        // Booking ID shouldn't be null

        validatableResponse.body("booking.firstname", Matchers.equalTo("Dipali"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Kunwar"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());
    }

}
