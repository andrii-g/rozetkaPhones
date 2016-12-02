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
    String tableName = "rozetkaDevicesTable";            //name of database table for data saving in it

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
        smartphones.expandClassBlock();
        smartphones.clickObtainableSmartphonesLink();

        smartphones.clickSortingDropdown();
        smartphones.chooseAscendingPriceSorting();
        Assert.assertEquals("text is not equal to expected", expectedSortingText, smartphones.getSortingDropdownText());

        String allDevicesData = smartphones.getAllDevicesData(tableName);
        smartphones.writeDataIntoFile(allDevicesData);                                                                  //saving information about devices into file (saving info to DB is added to function getAllDevicesData)

        System.out.println(dbHelper.getDBCreatedPhoneData(tableName));

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
