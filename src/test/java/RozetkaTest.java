import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PhonesPage;
import pages.RozetkaStartPage;
import pages.SmartphonesPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 16.11.2016.
 */
public class RozetkaTest {
    private WebDriver driver;
    private String expectedSortingText;

    @Before
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://rozetka.com.ua");
    }

    @Test
    public void test(){
        RozetkaStartPage startPage = new RozetkaStartPage(driver);
        expectedSortingText = "от дешевых к дорогим";

        startPage.clickPhoneTVSection();
        PhonesPage phonesPage = startPage.clickPhonesSection();

        SmartphonesPage smartphones = phonesPage.clickSmartphonesLink();

        smartphones.clickObtainableSmartphonesLink();
        smartphones.clickSortingDropdown();
        smartphones.chooseAscendingPriceSorting();
        Assert.assertEquals("text is not equal to expected", expectedSortingText, smartphones.getSortingDropdownText());

        smartphones.getDevicesData();
        System.out.println(smartphones.getDevicesData());
        smartphones.openSecondList();
        smartphones.getDevicesData();
        System.out.println(smartphones.getDevicesData());
        smartphones.openThirdList();
        smartphones.getDevicesData();
        System.out.println(smartphones.getDevicesData());;
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
