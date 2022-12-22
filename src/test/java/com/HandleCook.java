package com;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Set;

public class HandleCook {
    //get cookie
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
/*
    @AfterClass
    public void afterclass(){
        driver.close();
    }

 */
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

    @Test
    public void test01() throws InterruptedException {
        String value = "I4YmJhNmE1ODEyOGFmODE1MzAwZGQxMjQwNzA2YzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjgyMjQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADkwN2YzMzY5MWU4NzhjNDg1MGUxZDliMjhmZWZmNmFjYceWY1YYcmM%3DY2";
        System.out.println("登录失败，获取到cookie");
        Thread.sleep(30000);
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie1:cookies) {
            System.out.println("获取到cookie---》"+ cookie1);
            if (cookie1.getName().equals("apsid")) {
                System.out.println("登录成功，获取到cookie----->" + cookie1);
            }
        }
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
        System.out.println(cookie);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println("登录成功，获取到cookie----->");
        //apsid=I4YmJhNmE1ODEyOGFmODE1MzAwZGQxMjQwNzA2YzQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANjgyMjQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADkwN2YzMzY5MWU4NzhjNDg1MGUxZDliMjhmZWZmNmFjYceWY1YYcmM%3DY2;
        //[Hm_lpvt_c1c5f01e0fc4d75fd5cbb16f2e713d56=1670814597; expires=星期日, 17 八月 292278994 03:12:55 CST; path=/; domain=.coding.imooc.com, imooc_uuid=74b308e1-f565-45ad-9ad4-6a8eaf480503; expires=星期二, 12 十二月 2023 11:09:40 CST; path=/; domain=.imooc.com, sajssdk_2015_cross_new_user=1; expires=星期一, 12 十二月 2022 11:59:59 CST; path=/; domain=.imooc.com, IMCDNS=0; expires=星期二, 13 十二月 2022 11:09:51 CST; path=/; domain=.imooc.com, imooc_isnew=1; expires=星期二, 12 十二月 2023 11:09:41 CST; path=/; domain=.imooc.com, twelve2022=1670814533000; expires=星期五, 30 一月 2105 11:59:59 CST; path=/; domain=.imooc.com, sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185044f547ac2-0d61c3bd6b3f-42564130-1049088-185044f547c0%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDQ0ZjU0N2FjMi0wZDYxYzNiZDZiM2YtNDI1NjQxMzAtMTA0OTA4OC0xODUwNDRmNTQ3YzAifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22185044f547ac2-0d61c3bd6b3f-42564130-1049088-185044f547c0%22%7D; expires=星期五, 25 十月 2222 11:09:46 CST; path=/; domain=.imooc.com, cvde=63969b747b9cd-2; expires=星期日, 17 八月 292278994 03:12:55 CST; path=/; domain=.imooc.com, imooc_isnew_ct=1670814580; expires=星期二, 12 十二月 2023 11:09:41 CST; path=/; domain=.imooc.com, Hm_lvt_c1c5f01e0fc4d75fd5cbb16f2e713d56=1670814597; expires=星期二, 12 十二月 2023 11:09:56 CST; path=/; domain=.coding.imooc.com]
        //[Hm_lpvt_c1c5f01e0fc4d75fd5cbb16f2e713d56=1670825144; expires=星期日, 17 八月 292278994 03:12:55 CST; path=/; domain=.coding.imooc.com, imooc_uuid=3d7b3c95-067d-443f-9bb7-bc64040526f6; expires=星期二, 12 十二月 2023 02:05:27 CST; path=/; domain=.imooc.com, sajssdk_2015_cross_new_user=1; expires=星期一, 12 十二月 2022 11:59:59 CST; path=/; domain=.imooc.com, IMCDNS=0; expires=星期二, 13 十二月 2022 02:05:39 CST; path=/; domain=.imooc.com, imooc_isnew=1; expires=星期二, 12 十二月 2023 02:05:27 CST; path=/; domain=.imooc.com, twelve2022=1670825072000; expires=星期五, 30 一月 2105 11:59:59 CST; path=/; domain=.imooc.com, sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218504f05b55b-006c5eaca21924bc-42564130-1049088-18504f05b579a%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg1MDRmMDViNTViLTAwNmM1ZWFjYTIxOTI0YmMtNDI1NjQxMzAtMTA0OTA4OC0xODUwNGYwNWI1NzlhIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218504f05b55b-006c5eaca21924bc-42564130-1049088-18504f05b579a%22%7D; expires=星期五, 25 十月 2222 02:05:39 CST; path=/; domain=.imooc.com, cvde=6396c4a73be98-2; expires=星期日, 17 八月 292278994 03:12:55 CST; path=/; domain=.imooc.com, imooc_isnew_ct=1670825127; expires=星期二, 12 十二月 2023 02:05:27 CST; path=/; domain=.imooc.com, Hm_lvt_c1c5f01e0fc4d75fd5cbb16f2e713d56=1670825144; expires=星期二, 12 十二月 2023 02:05:43 CST; path=/; domain=.coding.imooc.com]
    }


}
