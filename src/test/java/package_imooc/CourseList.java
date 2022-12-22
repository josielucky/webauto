package package_imooc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseList {
    FirefoxDriver driver;
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        //设置浏览器驱动位置
        System.setProperty("webdriver.gecko.driver",
                "E:\\Idea\\untitled\\Module1\\Module1\\src\\driver\\Firefoxdriver\\v0.19.1\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imooc.com/");
        Thread.sleep(3000);
        //driver.findElement(By.className("js-close")).click();
    }
    @Test
    public void test01() throws InterruptedException {
        //通过列表索引获取每个课程的元素，以此来进行定位
        List<String> listString = ListCourseTitle();
        for (int i = 0; i<1; i++){
            //listString.size()
            Thread.sleep(10000);
            driver.findElement(By.xpath("//p[contains(text(),'"+listString.get(i)+"')]")).click();
            Thread.sleep(3000);
            driver.navigate().back();
            System.out.println("当前页面的title是:" + driver.getTitle());
            //driver.navigate().refresh();
            //driver.navigate().to("http://www.hao123.com");
            //System.out.println("跳转界面的title是:" + driver.getTitle());
            //driver.navigate().forward();
            System.out.println(listString.get(i));
            Thread.sleep(2000);
        }
    }
    /*
    public void GetPageNum(){
        List<Integer> pageNumList = new ArrayList<Integer>();
        List<WebElement> aElementList = driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for(WebElement aElement: aElementList){
            String pageNum = aElement.getText();
            if (isNumber(pageNum) == true){
                pageNumList.add(Integer.valueOf(pageNum).intValue());
                driver.findElement(By.partialLinkText("下一页"));
            }
        }
    }
    public boolean isNumber(String pageNum){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(pageNum);
        if(isNum.matches()){
            return true;
        }
        return false;
    }
     */
    public List<String> ListCourseTitle(){
        //将课程名字取到并存入到列表中
        List<String> listCourseTitle = new ArrayList<String>();
        List<WebElement> courseList = driver.findElements(By.className("ellipsis2"));
        for (WebElement courseName: courseList) {
            String courseTitle = courseName.getText();
            listCourseTitle.add(courseTitle);
            System.out.println(courseTitle);
        }
        return listCourseTitle;
    }

    @AfterClass
    public void afterclass(){
        driver.close();
    }

}
