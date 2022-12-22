package package_imooc;

import imooc.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

@Listeners(TestNGListenerScreen.class)
public class OneTestCase {
    FirefoxDriver driver;
    @Test
    public void f() throws InterruptedException {
        ProUtil proUtil = new ProUtil("user.properties");
        String user = null;
        String username;
        String password;
        int Lines = proUtil.GetLength();
        for (int i = 0; i < Lines; i++) {
            user = proUtil.GetPro("user" + i);//username=name>email
            username = user.split(">")[0];
            password = user.split(">")[1];
            WebElement Email = GetElement("username");
            WebElement Psd = GetElement("password");
            WebElement LoginButton = GetElement("loginbutton");

            Email.sendKeys(username);
            Psd.sendKeys(password);
            LoginButton.click();

            Thread.sleep(3000);
            try{
                WebElement UserPng = GetElement("headpng");
                Actions MouseActions = new Actions(driver);
                MouseActions.moveToElement(UserPng).perform();
                String UserInfo = GetElement("userinfo").getText();
                if(UserInfo.equals("宝慕林6538005")){
                    System.out.println("login succ");
                }else{
                    System.out.println("user info is not matched" + UserInfo);
                }
            }catch (Exception e){
                System.out.println("login fail");
            }
            Email.clear();
            Psd.clear();
        }

    }
    public By GetByLocal(String key){
        //封装定位方式
        ProUtil proUtil = new ProUtil("element.properties");
        String Locator = proUtil.GetPro(key);//username=name>email
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];

        if(LocatorBy.equals("id")){
            return By.id(LocatorValue);
        } else if (LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        } else if (LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }
    public WebElement GetElement(String key){
        //封装driver.findElement
        WebElement Element = driver.findElement(this.GetByLocal(key));
        return Element;
    }

    @BeforeTest
    public void beforeTest() throws InterruptedException {

    }
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imooc.com/user/newlogin/form_url/1005/");
        Thread.sleep(3000);
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
