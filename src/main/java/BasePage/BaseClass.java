package BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    protected static WebDriver driver;
    String URL = "https://iresource.smartdev.vn/";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
