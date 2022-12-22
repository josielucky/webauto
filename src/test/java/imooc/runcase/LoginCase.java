package imooc.runcase;

import imooc.handle.LoginHandle;
import io.qameta.allure.*;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


@Feature("登录操作")
public class LoginCase extends BaseCase{
    WebDriver driver;
    LoginHandle loginHandle;

    public static Logger logger = Logger.getLogger(LoginCase.class);
    @Parameters({"login_url"})
    @BeforeClass
    public void beforeClass(@Optional("https://www.imooc.com/user/newlogin/form_url/1005/, gecko")String login_url) throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");
        driver = GetDriver("gecko");
        driver.manage().window().maximize();
        driver.get(login_url);
        Thread.sleep(10000);
        //driver.findElement(By.id("js-signin-btn")).click();
        loginHandle = new LoginHandle(driver);
        loginHandle.ClickLogin();
        Thread.sleep(10000);
    }

    @AfterClass
    public void afterclass(){
        driver.close();
    }


    @Story("登录成功")
    @Description("用例描述：测试登录页面，验证用户名")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"username","password"})
    @Test
    public void TestLoginSucess(@Optional("16620816949, MXYmxy1994")String username, String password){
        Allure.description("输入账户名和密码");
        Allure.addAttachment("my attachement","my attachement content");
        try{
            Allure.addAttachment("add picture","image/png", new FileInputStream("E:\\Idea\\web_auto\\report\\pictuers"),"*.jpg");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        logger.debug("开始执行第一个case");
        loginHandle.SendEmail(username);
        loginHandle.SendPassword(password);
        loginHandle.ClickLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String username1 = loginHandle.GetUserText();
        Assert.assertEquals(username1, "宝慕林6538005");
    }

    @Story("登录失败")
    @Description("用例描述：测试页，用例2")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TestCase2(){
        Allure.description("测试用例2");
        System.out.println("用例2");
    }
    /*
    public void TestLoginEmailError(){
        logger.debug("开始执行第二个case");
        loginHandle.SendEmail("16620816949");
        loginHandle.SendPassword("55555");
        //loginHandle.ClickSenvenBox();
        loginHandle.ClickLogin();
    }
     */

}
