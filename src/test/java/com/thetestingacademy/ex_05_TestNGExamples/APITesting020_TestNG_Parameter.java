package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("I am Demo!");
        System.out.println("You are running this Parameter!");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome Browser!");
        }

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox Browser!");
        }
    }


}
