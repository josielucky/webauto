package imooc.page;

import imooc.util.ProUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;


public class BasePage {
    public WebDriver driver1;
    public static Logger logger = Logger.getLogger(BasePage.class);
    public BasePage(WebDriver driver){
        this.driver1 = driver;
    }

    public WebElement GetElement(String key){
        //获取元素，判断10次，超过10次还未找到则不再等待
        boolean flag = true;
        int i = 0;
        WebElement element = null;
        while (flag){
            try{
                element = driver1.findElement(this.GetByLocal(key));
                flag = false;
            }catch (Exception e){
                i = i+1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                if(i == 10){
                    flag = false;
                }
            }
        }
        return element;
    }

    public By GetByLocal(String key){
        //封装定位方式
        ProUtil proUtil = new ProUtil("element.properties");
        logger.debug("定位信息的key为："+ key);
        String Locator = proUtil.GetPro(key);//username=name>email
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        logger.debug("定位方式为："+ LocatorBy);
        logger.debug("定位值为："+ LocatorValue);

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
    public void MoveToElement(WebElement ToElement){
        Actions MoseActions = new Actions(driver1);
        MoseActions.moveToElement(ToElement).perform();
    }

    public boolean GetCookie(String key){
        boolean flag = false;
        driver1.manage().getCookies();
        Set<Cookie> cookies = driver1.manage().getCookies();
        for(Cookie cookie1:cookies) {
            System.out.println("获取到cookie---》"+ cookie1);
            if (cookie1.getName().equals(key)) {
               flag = true;
            }
        }
        return flag;

    }

}

