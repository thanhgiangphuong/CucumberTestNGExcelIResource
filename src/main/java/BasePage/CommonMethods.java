package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonMethods {

    // Constructor
    public CommonMethods() {
    }

    // Reusable common methods
    public static void compareText(String expected, String actual) {
        String ExpectedText = expected;
        String ActualText = actual;
        Assert.assertEquals(actual, expected);
    }
    public boolean compareFalse(boolean conditionF) {
        Assert.assertFalse(conditionF);
        return false;
    }
    public static boolean compareTrue(boolean conditionT) {
        Assert.assertTrue(conditionT);
        return true;
    }
    public static void ThreadSleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
    public static void Logout(WebElement element) {
        element.click();
    }
    public static String getURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }
}
