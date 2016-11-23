package pages;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrii_Grygoruk on 11/21/2016.
 */
public abstract class BasePage {
    private static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public static WebDriver getDriver(){
        return driver;
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
