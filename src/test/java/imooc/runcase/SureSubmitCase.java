package imooc.runcase;

import imooc.handle.SureSubmitHandle;
import io.qameta.allure.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SureSubmitCase extends BaseCase{
    WebDriver driver;
    SureSubmitHandle sure_submit_handle;

    public static Logger logger = Logger.getLogger(SureSubmitCase.class);
   // @Parameters({"submit_url"})
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");
        //String submit_url = "https://order.imooc.com/pay/confirm?goods_ids=2878&from=carts";
        driver = GetDriver("gecko");
        driver.manage().window().maximize();
        //driver.get(submit_url);
        Thread.sleep(10000);
        sure_submit_handle = new SureSubmitHandle(driver);
    }

    @AfterClass
    public void afterclass(){
        driver.close();
    }


    @Story("购物车")
    @Description("用例描述：确认订单")
    @Severity(SeverityLevel.CRITICAL)
   // @Parameters({"submit_url"})
    @Test
    public void LoginSureSubmit() throws InterruptedException {
        String submit_url = "https://order.imooc.com/pay/confirm?goods_ids=2878&from=carts";
        Allure.description("确认订单");
        logger.debug("开始执行第一个case");
        driver.get(submit_url);
        Thread.sleep(3000);
        //sure_submit_handle.SetUserCookie();
        String value = "I4YmJhNmE1ODEyOGFmODE1MzAwZGQxMjQwNzA2YzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjgyMjQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADkwN2YzMzY5MWU4NzhjNDg1MGUxZDliMjhmZWZmNmFjYceWY1YYcmM%3DY2";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null, true);
        //System.out.println(cookie);
        String ckname = driver.manage().getCookieNamed("apsid").getValue();
        System.out.println(ckname);
        System.out.println(123);
        driver.manage().addCookie(cookie);

        driver.get(submit_url);

        Thread.sleep(3000);
        String submit_title = sure_submit_handle.GetCourseTitle();
        boolean flag = submit_title.contains("确认订单");
        Assert.assertEquals(flag, true);
        sure_submit_handle.ClickSureSubmitElement();

    }
/*
    @Story("购物车")
    @Description("用例描述：确认订单2")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"submit_url"})
    @Test
    public void SureSubmit(String submit_url){
        Allure.description("确认订单2");
        logger.debug("开始执行第一个case2");
        driver.get(submit_url);
        String submit_title = sure_submit_handle.GetCourseTitle();
        boolean flag = submit_title.contains("确认订单");
        Assert.assertEquals(flag, true);
    }

 */
}
