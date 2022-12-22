package package_imooc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class SeleniumOne {
    FirefoxDriver driver;
    public void GetFirefox() throws InterruptedException {

        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imooc.com/");
        Thread.sleep(3000);
    }

    public void GetElement() throws InterruptedException {
        ////div/a[1]/p[contains(text(),"Vue3源码解析，打造自己的Vue3框架，领悟尤大思维精髓")]
        //关闭活动弹窗
        //driver.findElementByXPath("//a/span[@class='close imv2-add_circle_o js-close-activity']").click();
        //点击注册
        driver.findElementByXPath("//div/ul/li[2]/a[@id='js-signin-btn']").click();
        //driver.findElementById("js-signin-btn").click();
        Thread.sleep(3000);
        driver.findElementByName("email").sendKeys("16620816949");
        driver.findElementByName("password").sendKeys("MXYmxy1994");
        //取消勾选7天自动登录
        WebElement nodeelement = driver.findElementByXPath("//div/label[@class='rlf-autoin l']");
        nodeelement.findElement(By.tagName("input")).click();
        driver.findElementByLinkText("忘记密码").click();
        driver.findElementByPartialLinkText("遇到问题").click();
        //点击快速注册
        //driver.findElementByXPath("//div/span[@class='xa-showSignup']").click();
        //Thread.sleep(2000);
        //点击登录
        List<WebElement> buttonElement = driver.findElements(By.className("rlf-group"));
        buttonElement.get(4).click();
        Thread.sleep(3000);
        driver.close();

    }

    public static void main(String[] args) throws InterruptedException {
        SeleniumOne seleniumOne = new SeleniumOne();
        seleniumOne.GetFirefox();
        seleniumOne.GetElement();


    }
}
