package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class TestMethodDemo {
    @Story("test1")
    @Description("用例描述：判断1和2是否相等")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Story("test2")
    @Description("用例描述：判断1和1是否相等")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Story("test3")
    @Description("用例描述：判断字符串aaa是否相等")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
    @Story("logdemo")
    @Description("用例描述：运行时异常")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void logDemo(){
        Reporter.log("这是我自己写的日志");
        throw new RuntimeException("这是我自己的运行时异常");
    }
}
