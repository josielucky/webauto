package package_imooc;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.commons.mail.SimpleEmail;


public class TestNGCase {
    private static Logger logger = Logger.getLogger(TestNGCase.class);
    FirefoxDriver driver;
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        PropertyConfigurator.configure("log4j.properties");
        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imooc.com/user/newlogin/form_url/1005/");
        Thread.sleep(3000);
    }
    @Test
    public void test01(){
        logger.debug("邮箱信息");
        driver.findElement(By.name("email")).sendKeys("133333");
        //Assert.assertSame(1,2);
        System.out.println("第1个case失败");
    }
    @Test
    public void test02(){
        logger.error("错误email");
        driver.findElement(By.name("email")).sendKeys("16620816949");
        System.out.println("第2个case");
    }
    @Test
    public void test03(){
        driver.findElement(By.name("email")).sendKeys("16620816949");
        System.out.println("第3个case");
    }
    @Test
    public void test04(){
        driver.findElement(By.name("email")).sendKeys("16620816949");
        System.out.println("第4个case");
    }
    @AfterClass
    public void afterclass(){
        driver.close();
        SendToEmail();
    }
    public void SendToEmail(){
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("16620816949@163.com","NJJECOUWLYYBFEBX");
        try {
            email.setFrom("16620816949@163.com");
            email.addTo("16620816949@163.com");
            email.setSubject("selenium web_auto");
            email.setMsg("test");
            email.send();
            logger.debug("发送成功");
        }catch (EmailException e){
            e.printStackTrace();
        }

    }
}
