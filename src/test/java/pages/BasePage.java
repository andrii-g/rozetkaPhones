package pages;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrii_Grygoruk on 11/21/2016.
 */
public class BasePage {
    private static WebDriver driver;
//    private WebDriverWait wait;
//    private final Wait<WebDriver> waiter = new WebDriverWait(this.getDriver(), 5, 1000);
    private Wait<WebDriver> wait = new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);


    public void waitFor(WebElement element){
//        wait = new WebDriverWait(this.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public BasePage(){

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public static void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua");
    }

    public static void tearDown(){
        driver.close();
    }
}
