package imooc.handle;

import imooc.page.LoginPage;
import imooc.runcase.LoginCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginHandle {
    public static Logger logger = Logger.getLogger(LoginHandle.class);
    public LoginPage loginPage;
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void SendEmail(String email){
        logger.debug("您输入的用户信息：" + email);
        loginPage.GetEmailElement().sendKeys(email);
    }
    public void SendPassword(String password){
        logger.debug("您输入的用户密码：" + password);
        loginPage.GetPasswordElement().sendKeys(password);
    }
    public void ClickSenvenBox(){
        loginPage.GetSenvenElement().click();
    }
    public void ClickLogin(){
        logger.debug("点击登录按钮");
        loginPage.GetLoginButtonElement().click();
    }


    public String GetUserText(){
        loginPage.MoveToElement(loginPage.GetUserPngElement());
        String username = loginPage.GetUserInfoElement().getText();
        return username;

    }
}
