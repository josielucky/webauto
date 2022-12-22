package imooc.runcase;

import imooc.handle.CourseHandle;
import io.qameta.allure.*;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class CourseCase extends BaseCase{
    WebDriver driver;
    CourseHandle courseHandle;

    public static Logger logger = Logger.getLogger(CourseCase.class);
    @Parameters({"course_url","browser"})
    @BeforeClass
    public void beforeClass(@Optional("https://www.imooc.com/class/303.html/, gecko")String url, String browser) throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");

        driver = GetDriver(browser);
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(10000);
        //driver.findElement(By.id("js-signin-btn")).click();
        courseHandle = new CourseHandle(driver);
        Thread.sleep(10000);
    }

    @AfterClass
    public void afterclass(){
        driver.close();
    }


    @Story("购物车")
    @Description("用例描述：添加课程测试")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"coursename"})
    @Test
    public void AddCourseSucess(@Optional("剑指Java面试-Offer直通车")String coursename){
        Allure.description("课程");
        logger.debug("开始执行第一个case");
        String course_title = courseHandle.GetCourseTitle();
        boolean flag = course_title.contains(coursename);
        Assert.assertEquals(flag, true);
    }
}
