package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting016_BeforeTest {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void get_Token(){
        System.out.println("Before GET Token");

    }

    @BeforeTest
    public void get_BookingId(){
        System.out.println("Before GET Booking");
    }

    @Test
    public void test_PUT(){
        // Token and BookingID
        System.out.println("PUT REQUEST");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close");
    }
}
