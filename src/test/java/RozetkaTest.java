import helper.DBHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


/**
 * Created by User on 16.11.2016.
 */
public class RozetkaTest{

    private String expectedSortingText;
    private String expectedMessage;
    DBHelper dbHelper = new DBHelper();

    @Before
    public void setUp(){
        BasePage.setUp();
    }

    @Test
    public void test(){

        RozetkaStartPage startPage = new RozetkaStartPage();
        expectedSortingText = "от дешевых к дорогим";
        expectedMessage = "Вместе дешевле";

        startPage.clickPhoneTVSection();
        PhonesPage phonesPage = startPage.clickPhonesSection();

        SmartphonesPage smartphones = phonesPage.clickSmartphonesLink();
        smartphones.clickObtainableSmartphonesLink();

        smartphones.clickSortingDropdown();
        smartphones.chooseAscendingPriceSorting();
        Assert.assertEquals("text is not equal to expected", expectedSortingText, smartphones.getSortingDropdownText());

        String allDevicesData = smartphones.getAllDevicesData();
        smartphones.writeDataIntoFile(allDevicesData);                                                                  //saving information about devices into file (saving info to DB is added to function getAllDevicesData)

        System.out.println(dbHelper.getDBCreatedPhoneData());

        ProductCartPage productCartPage = smartphones.clickFirstProduct();
        productCartPage.clickBuyButton();
        productCartPage.getRecommendationBlockText();

        Assert.assertTrue("Failed assert that actual text contains expected. Expected: '" + expectedMessage + "' Actual: '" + productCartPage.getRecommendationBlockText() +"'",
                productCartPage.getRecommendationBlockText().contains(expectedMessage));

    }

    @After
    public void tearDown(){
        BasePage.tearDown();
    }

}
