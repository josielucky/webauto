package imooc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //当前页面发生的
    //输入了信息
    //点击了信息
    //在某个页面，找到某个元素，输入了xx信息
    //在某个页面，找到了某个元素，点击了xx信息

    //按照页面进行所有元素的封装
    //按照页面对所有的元素的操作进行封装
    //按照页面对所有的case进行封装

    //1.创建登录页面，把页面元素都封装起来
    // loginPage
    public LoginPage(WebDriver driver){
        super(driver);
    }
    //获取元素
    /*
    * 获取 邮箱
    * 获取 密码
    * 获取 7天登录
    * 获取 登录按钮
    * */
    public WebElement GetEmailElement(){
        return GetElement("username");
    }
    public WebElement GetPasswordElement(){
        return GetElement("password");
    }
    public WebElement GetSenvenElement(){
        return GetElement("senven");
    }
    public WebElement GetLoginButtonElement(){
        return GetElement("loginbutton");
    }
    public WebElement GetUserPngElement(){
        return GetElement("headpng");
    }
    public WebElement GetUserInfoElement(){
        return GetElement("userinfo");
    }



    //LoginHandle.java
    /*
     * 输入 邮箱
     * 输入密码
     * 点击7天登录
     * 点击登录按钮
     */

    //LoginCase.java
    /*
    1.
    * 输入正确邮箱
    * 输入错误密码
    * 点击登录
    * 2.
    * 输入错误邮箱
    * 输入错误密码
    * 点击登录
    * */

    //元素，数据，case分离
}
