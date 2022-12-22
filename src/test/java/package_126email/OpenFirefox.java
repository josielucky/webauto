package package_126email;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefox {
    public static FirefoxDriver GetFirefox(){
        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}