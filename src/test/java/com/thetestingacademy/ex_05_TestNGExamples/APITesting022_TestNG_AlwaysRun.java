package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting022_TestNG_AlwaysRun {

//    @Test
//    public void test01(){
//        Assert.assertTrue(true);
//    }
//
//    @Test(alwaysRun = true)
//    public void test02(){
//        Assert.assertTrue(true);
//    }
//    @Test
//    public void test03(){
//        Assert.assertTrue(true);
//    }

    @Test
    public void test_new_register(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void test_login_page(){
        Assert.assertTrue(true);
    }

    @Test
    public void test_normal(){
        Assert.assertTrue(true);
    }
}
