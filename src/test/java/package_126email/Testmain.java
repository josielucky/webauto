package package_126email;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Testmain {
    public static void main(String[] args) throws InterruptedException {
        OpenFirefox openFirefox = new OpenFirefox();
        FirefoxDriver driver1 = openFirefox.GetFirefox();
        TestData testData = new TestData();
        Test_LoginEmail.login(driver1, testData.getUrl(), testData.getEmail(),testData.getPassword());

    }
}

