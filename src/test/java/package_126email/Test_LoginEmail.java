package package_126email;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_LoginEmail{
    public static void login (FirefoxDriver driver, String url, String email, String password) throws InterruptedException {

        driver.get(url);
        Thread.sleep(3000);
        //进入iframe表单
        WebElement ele = driver.findElementByXPath("//*[@id='loginDiv']/iframe");
        driver.switchTo().frame(ele);
        //执行登录操作
        Thread.sleep(3000);
        driver.findElementByName("email").sendKeys(email);
        driver.findElementByName("password").sendKeys(password);

    }
}
