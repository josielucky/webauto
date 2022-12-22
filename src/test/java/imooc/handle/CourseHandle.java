package imooc.handle;

import imooc.page.CoursePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CourseHandle {
    static Logger logger = Logger.getLogger(CourseHandle.class);
    public CoursePage coursePage;
    public WebDriver driver;
    public CourseHandle(WebDriver driver){
        this.driver = driver;
        coursePage = new CoursePage(driver);
    }
    /*
    点击添加购物车
     */
    public void ClickAddCart(){
        coursePage.GetCartElement().click();

    }
    /*
    点击立即购买
     */
    public void ClickByNow(){
        coursePage.GetBuyElement().click();
    }
    /*
    点击模态框按钮
     */
    public void ClickCartSure(){
        coursePage.GetSureElement().click();
    }
    /*
    点击购物车按钮
     */
    public void ClickCartElement(){
        coursePage.GetCartElement().click();
    }
    /*
    获取购物车商品数量
     */
    public int GetCartNum(){
        int CartNum;
        try{
            CartNum = Integer.parseInt(coursePage.GetCartNumElement().getText());
        }catch (Exception e){
            CartNum = 0;
        }
        return CartNum;
    }
    /*
    植入cookie
     */
    public void SetUserCookie(){
        String value = "I4YmJhNmE1ODEyOGFmODE1MzAwZGQxMjQwNzA2YzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjgyMjQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADkwN2YzMzY5MWU4NzhjNDg1MGUxZDliMjhmZWZmNmFjYceWY1YYcmM%3DY2";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        System.out.println(cookie);
        driver.manage().addCookie(cookie);
    }
    /*
    获取title
     */
    public String GetCourseTitle(){
        return driver.getTitle();
    }
}
