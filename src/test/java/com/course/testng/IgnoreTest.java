package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1");
    }
    @Test(enabled = false)
    //忽略测试
    public void ignore2(){
        System.out.println("ignore2");
    }
    @Test(enabled = true)
    //不写时也是默认为true
    public void ignore3(){
        System.out.println("ignore3");
    }
}
