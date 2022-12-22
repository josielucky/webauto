package imooc.runcase;

import imooc.handle.SureSubmitHandle;
import io.qameta.allure.*;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SureSubmitCase extends BaseCase{
    WebDriver driver;
    SureSubmitHandle sure_submit_handle;

    public static Logger logger = Logger.getLogger(SureSubmitCase.class);
    @Parameters({"submit_url","browser"})
    @BeforeClass
    public void beforeClass(@Optional("https://www.imooc.com/class/303.html/, gecko")String url, String browser) throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");

        driver = GetDriver(browser);
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(10000);
        sure_submit_handle = new SureSubmitHandle(driver);
        Thread.sleep(10000);
    }

    @AfterClass
    public void afterclass(){
        driver.close();
    }


    @Story("购物车")
    @Description("用例描述：确认订单")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"submit_url"})
    @Test
    public void LoginSureSubmit(String submit_url){
        Allure.description("确认订单");
        logger.debug("开始执行第一个case");
        sure_submit_handle.SetUserCookie();
        driver.get(submit_url);
        String submit_title = sure_submit_handle.GetCourseTitle();
        boolean flag = submit_title.contains("确认订单");
        Assert.assertEquals(flag, true);
        sure_submit_handle.ClickSureSubmitElement();


    }

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
}
