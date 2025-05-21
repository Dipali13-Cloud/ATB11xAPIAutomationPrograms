package com.thetestingacademy.ex_06_TestAssetions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITesting028_RestAssured_TestNG_AssertJ_Assertions{
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

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

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Dipali"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Kunwar"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());


        bookingID =  response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Dipali");
        Assert.assertEquals(lastname,"Kunwar");
        Assert.assertNotNull(bookingID);

        //
        // AssertJ( 3rd- Lib to Assertions) - 20%

        assertThat(bookingID).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Dipali").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();

        //        String s = ""; //Empty
        //        String s2 = " "; //Blank

    }

}
