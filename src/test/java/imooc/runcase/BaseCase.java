package imooc.runcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseCase {
    public WebDriver GetDriver(String browser){
        WebDriver driver;
        if (browser.equalsIgnoreCase("gecko")){
            System.setProperty("webdriver.gecko.driver",
                    "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
            driver = new FirefoxDriver();

        }else{
            System.setProperty("webdriver.chrome.driver",
                    "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }
}
