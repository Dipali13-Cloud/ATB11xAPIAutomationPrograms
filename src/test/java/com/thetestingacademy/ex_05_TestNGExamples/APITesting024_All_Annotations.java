package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.*;

public class APITesting024_All_Annotations {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("After Test");
    }

    @AfterClass
    void demo7(){
        System.out.println("After Class");
    }

    @AfterTest
    void demo8(){
        System.out.println("After Test");
    }

    @AfterSuite
    void demo9(){
        System.out.println("After Suite");
    }
}
