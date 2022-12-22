package imooc.handle;

import imooc.page.SureSubmitPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class SureSubmitHandle {
    public WebDriver driver;
    public SureSubmitPage suresubmitpage;

    public SureSubmitHandle(WebDriver driver){
        this.driver = driver;
        suresubmitpage = new SureSubmitPage(driver);
    }

    public void ClickSureSubmitElement(){
        //点击确认订单按钮
        suresubmitpage.GetSureSubmitElement().click();
    }
    /*
 获取title
  */
    public String GetCourseTitle(){
        return driver.getTitle();
    }

    public void SetUserCookie(){
        String value = "I4YmJhNmE1ODEyOGFmODE1MzAwZGQxMjQwNzA2YzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjgyMjQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADkwN2YzMzY5MWU4NzhjNDg1MGUxZDliMjhmZWZmNmFjYceWY1YYcmM%3DY2";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        System.out.println(cookie);
        driver.manage().addCookie(cookie);
    }
}
