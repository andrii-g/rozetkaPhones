import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.PhonesPage;
import pages.RozetkaStartPage;
import pages.SmartphonesPage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 16.11.2016.
 */
public class RozetkaTest{

    private String expectedSortingText;

    @Before
    public void setUp(){
        BasePage.setUp();
    }

    @Test
    public void test(){
        RozetkaStartPage startPage = new RozetkaStartPage();
        expectedSortingText = "от дешевых к дорогим";

        startPage.clickPhoneTVSection();
        PhonesPage phonesPage = startPage.clickPhonesSection();

        SmartphonesPage smartphones = phonesPage.clickSmartphonesLink();
        smartphones.expandClassBlock();
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
        System.out.println(smartphones.getDevicesData());
    }

    @After
    public void tearDown(){
        BasePage.tearDown();
    }

}
