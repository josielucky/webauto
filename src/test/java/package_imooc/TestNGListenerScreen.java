package package_imooc;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListenerScreen extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr){
        TestNGCase tc = (TestNGCase)tr.getInstance();
        WebDriver driver = tc.driver;
        this.TakeScreenShot(driver);
        super.onTestFailure(tr);
    }
    public void TakeScreenShot(WebDriver driver){
        //添加一个截图方法
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String curTime = sdf.format(new Date());
        //获取当前类名
        String curClassName = this.getClass().getName();
        //路径
        String curPath = System.getProperty("user.dir");
        String pngPath = curClassName+"_"+curTime+".png";

        File Screenfile = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(Screenfile.toPath(), new File(curPath +"\\"+pngPath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
