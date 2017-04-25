package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CricketPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"form-login\"]/div[1]/div[1]/div/a")
    public WebElement popUplink;

    @FindBy(id="slio")
    public WebElement lnkLogin;

    @FindBy(id="slio")
    public WebElement lnkLogout;

    @FindBy(id="login-em")
    public WebElement fldUsername;

    @FindBy(id="login-pw")
    public WebElement fldPassword;

    @FindBy(xpath="//*[@id='form-login']/div[3]/input")
    public WebElement btnLogin;

    @FindBy(id="err-pw")
    public WebElement errorMessage;


    public CricketPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){

        final Object lock=new Object();

        lnkLogin.click();
        driver.switchTo().frame(0);

        //sleep(1);

        try{
            if(popUplink.isDisplayed()){
                popUplink.click();
                //Thread.sleep(2000);
                driver.switchTo().frame(0);
            }
        }catch(Exception e){}

        fldUsername.sendKeys(username);
        fldPassword.sendKeys(password);

        //sleep(1);
        btnLogin.click();
        //sleep(1);

        Thread thread1=new Thread(new Runnable(){

            @Override
            public void run(){
                if(CricketPage.this.errorMessage.isDisplayed()){

                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){}

                    synchronized (lock){
                        lock.notifyAll();
                    }
                }
            }

        });

        Thread thread2=new Thread(new Runnable(){

            @Override
            public void run(){
                WebElement element=null;
                try{
                    element=new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(lnkLogout));
                    element.click();
                }catch(WebDriverException e){}

                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){}

                synchronized(lock){
                    lock.notifyAll();
                }
            }
        });

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {}
        }

        System.out.println();
    }

    private void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
