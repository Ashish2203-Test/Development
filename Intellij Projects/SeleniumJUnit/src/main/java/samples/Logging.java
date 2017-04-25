package samples;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Logging {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, System.getProperty("user.dir")+"/src/main/java/samples/browserlog");

        ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.google.com/");

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){}


//        driver.quit();

    }

}
