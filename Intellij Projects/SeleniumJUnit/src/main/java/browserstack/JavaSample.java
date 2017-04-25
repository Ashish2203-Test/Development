package browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class JavaSample {

    public static final String USERNAME = "Rus123";
    public static final String AUTOMATE_KEY = "d02a7510-9494-448c-a419-d8c518ccb8cc";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@ondemand.saucelabs.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }
}
