package package_imooc;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {
    FirefoxDriver driver;
    public void GetFirefox() throws InterruptedException {

        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imooc.com/user/newlogin/form_url/1005/");
        Thread.sleep(3000);
    }

    public void InputElement() throws InterruptedException {

        WebElement EmailElement = driver.findElement(By.name("email"));
        //获取账号输入框的某个属性
        String UserInfo = EmailElement.getAttribute("placeholder");
        EmailElement.sendKeys("16620816949");
        driver.findElementByName("password").sendKeys("MXYmxy1994");
        Thread.sleep(3000);
        //EmailElement.clear();
        driver.findElementByClassName("moco-btn-red").click();
        System.out.println(UserInfo);//请输入登录手机号/邮箱
        String Mobile = EmailElement.getAttribute("value");
        System.out.println(Mobile);//16620816949
        //查看是否是可点击的
        boolean info = EmailElement.isEnabled();
        System.out.println(info);//true
        Thread.sleep(3000);

    }

    public void Radio() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(3000);
        //driver.findElementByClassName("edit-info-btn js-edit-info").click();
        Thread.sleep(2000);
        //性别单选框通过集合来操作
        List<WebElement> SexList = driver.findElements(By.name("sex"));
        //判断是否被勾选，没被勾选则点击选择
        for (WebElement sex: SexList){
            if (sex.isSelected()){
                break;
            }else{
                SexList.get(3).click();
            }
        }
        //driver.close();

    }
    public void CheckBox() throws InterruptedException {
        //多选框操作，自动登录勾选
        WebElement Box = driver.findElementById("auto-signin");
        System.out.println(Box.isSelected());
        System.out.println(Box.isEnabled());
        Thread.sleep(3000);
        Box.click();
        driver.close();
    }
    public void Button() throws InterruptedException {
        //登录按钮操作
        WebElement ButtonElement = driver.findElementByClassName("moco-btn-lg");
        System.out.println(ButtonElement.isEnabled());//true
        //通过js脚本隐藏登录按钮
        String JSString = "document.getElementsByClassName(\'moco-btn-lg\')[0].style.display=\'None\';";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(JSString);
        Thread.sleep(3000);
        WebElement ButtonElement1 = driver.findElementByClassName("moco-btn-lg");
        System.out.println(ButtonElement1.isEnabled());//true
    }
    public void UpFile() throws InterruptedException {
        //跳转到更换头像界面
        driver.get("https://www.imooc.com/user/setbindsns");
        //定位到头像图片
        WebElement HeadPng = driver.findElementByClassName("avator-mode");
        //滑动到弹出更换头像
        Actions action = new Actions(driver);
        //.perform() 将动作提交
        action.moveToElement(HeadPng).perform();
        //点击更换头像
        driver.findElementByClassName("js-avator-link").click();
        Thread.sleep(3000);
        //通过sendkeys来跟换头像,sendkeys只针对属性是input标签的元素
        WebElement Upload = driver.findElementById("upload");
        Upload.sendKeys("C:\\Users\\mxy\\Pictures\\a.jpg");
        Thread.sleep(3000);

    }
    public void upfile01() throws InterruptedException, IOException {
        driver.get("https://www.imooc.com/user/setbindsns");
        Thread.sleep(2000);
        WebElement header = driver.findElementByClassName("avator-img");
        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();
        driver.findElementByClassName("js-avator-link").click();
        driver.findElementByClassName("avator-btn-fake").click();
        Runtime.getRuntime().exec("C:\\Users\\mxy\\Pictures\\a.jpg");

    }
    public void WebForm() throws InterruptedException {
        WebElement EmailElement = driver.findElement(By.name("email"));
        //获取账号输入框的某个属性
        String UserInfo = EmailElement.getAttribute("placeholder");
        EmailElement.sendKeys("16620816949");
        driver.findElementByName("password").sendKeys("MXYmxy1994");
        Thread.sleep(3000);
        //submit提交适用于post请求
        driver.findElementById("signup-form").submit();
        System.out.println(UserInfo);



    }
    public void SelectOption() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(10000);
        //driver.findElementByClassName("edit-info-btn js-edit-info").click();
        Thread.sleep(10000);
        WebElement UserForm = driver.findElementById("profile");
        UserForm.findElement(By.id("job")).click();
        List<WebElement> Joblist = driver.findElements(By.tagName("option"));
        Joblist.get(5).click();

    }
    public void SelectOptionSelenium() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(10000);
        //driver.findElementByClassName("edit-info-btn js-edit-info").click();
        Thread.sleep(10000);
        WebElement UserForm = driver.findElementById("profile");
        WebElement Job = UserForm.findElement(By.id("job"));
        Select DownList = new Select(Job);
        DownList.selectByIndex(8);
        Thread.sleep(2000);
        DownList.selectByValue("8");
        Thread.sleep(2000);
        DownList.selectByVisibleText("软件测试工程师");
        Thread.sleep(2000);

    }
    public void MouseAction() throws InterruptedException {
        driver.get("https://www.imooc.com/");
        //WebElement LoginElement = driver.findElementById("js-signin-btn");
        Actions actions = new Actions(driver);
        //actions.click(LoginElement).perform();
        List <WebElement> MenElement = driver.findElements(By.className("item"));
        WebElement SubElement = MenElement.get(1);
        actions.moveToElement(SubElement).perform();
        Thread.sleep(2000);
        driver.findElementByXPath("//div[@class='lore']/p/a[contains(text(),'爬虫')]").click();
        //driver.findElementByXPath("//div[@class='menuContent']/div[2]/span[@class='sub-title']").click();
        //driver.findElementByLinkText("//coding.imooc.com/?c=java").click();


    }

    public void SwichIframe() throws InterruptedException {
        driver.get("https://www.imooc.com/article/publish#");
        try {
            driver.findElementById("ueditor_0").sendKeys("josieinput");
        }catch (Exception e){
            System.out.println("定位错误");
        }
        WebElement iframeElement = driver.findElementById("ueditor_0");
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        WebElement Ueditor = driver.findElementByTagName("p");
        Actions actions = new Actions(driver);
        actions.moveToElement(Ueditor).click().sendKeys("test input..").perform();
    }

    public void WindowsHandle() throws InterruptedException {
        //通过handles来切换浏览器里所有的窗口
        Set<String> Handle = driver.getWindowHandles();
        String CurHandle = driver.getWindowHandle();
        System.out.println(CurHandle);
        //当前窗口和所有窗口对比，再切换
        for(String s: Handle){
            if(s.equals(CurHandle)){
                System.out.println(s);
                continue;
            }else{
                driver.switchTo().window(s);
            }

        }
        Thread.sleep(3000);

        //driver.findElement(By.linkText("/class/519.html"));//不知道为什么就是定位不到
        driver.findElementByLinkText("全部");
        //driver.get("https://coding.imooc.com/class/519.html");
        Thread.sleep(3000);


    }
    public void AlertWindow(){

        driver.switchTo().alert().accept();
    }

    public void Wait(){
        //强制等待
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //隐式等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("js-sign-btn")));
    }

    public static void main(String[] args) throws InterruptedException{
        SeleniumAction seleniumAction = new SeleniumAction();
        seleniumAction.GetFirefox();
        //seleniumAction.InputElement();
        //seleniumAction.Radio();
        //seleniumAction.CheckBox();
        //seleniumAction.Button();
        //seleniumAction.UpFile();
        //seleniumAction.upfile01();
        //seleniumAction.WebForm();
        //seleniumAction.SelectOption();
        //seleniumAction.SelectOptionSelenium();
        seleniumAction.MouseAction();
        //seleniumAction.SwichIframe();
        //seleniumAction.WindowsHandle();


    }
}
