package package_imooc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BuyShop {
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

    }
    @Test
    public void test01() throws InterruptedException {
        int a = 0;
        int BeforeNumber = 0;
        String CourseTitle = driver.getTitle();
        if(CourseTitle.contains("剑指Java面试-Offer直通车")){
            System.out.println(CourseTitle);
            try {
                BeforeNumber = Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
            }catch(Exception e){
                System.out.println("购物车数量为空");
            }
            driver.findElement(By.className("js-addcart")).click();
            Thread.sleep(3000);
            String CourNum = driver.findElement(By.className("js-cart-num")).getText();
            int AfterNumber = Integer.parseInt(CourNum);
            a = AfterNumber-BeforeNumber;
            if(a == 1){
                System.out.println("添加购物车成功");
            }
        }
    }
    @Test
    public void test02(){
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
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://coding.imooc.com/class/303.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod执行完毕");
    }

}






