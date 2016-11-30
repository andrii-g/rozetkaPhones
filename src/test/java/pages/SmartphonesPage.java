package pages;

import helper.DBHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 16.11.2016.
 */
public class SmartphonesPage extends BasePage{

    public SmartphonesPage() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }
    static int id = 0;

    @FindBy(xpath = "//i[.='Доступные смартфоны']//parent::span[contains(@class, 'parametrs')]")
    WebElement obtainableSmartphonesLink;

    @FindBy(xpath = "//a[@name='drop_link']")
    WebElement sortingDropdown;

    @FindBy(xpath = "//a[.='от дешевых к дорогим']")
    WebElement priceAscendingLink;

    @FindBy(xpath = "//li[@id='page2']/a")
    WebElement secondListLink;

    @FindBy(xpath = "//li[@id='page3']/a")
    WebElement thirdListLink;

    @FindBy(xpath = "//div[@name='filter_parameters_title'][contains(text(), 'Класс')]")
    WebElement expandClassBlock;

    @FindBy(xpath = "//li[contains(@class, 'active')]/span")
    WebElement currentPageNumberBlock;

    @FindBy(xpath = "(//div[@class='over-wraper']//div[contains(@id, 'image')])[1]")
    WebElement firstDeviceButton;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][1]//div[contains(@class, 'g-price-uah')]"),
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][2]//div[contains(@class, 'g-price-uah')]"),
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][3]//div[contains(@class, 'g-price-uah')]")
    })
    List<WebElement> devicePrice;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][1]//div[contains(@class, 'g-i-tile-i-title')]"),
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][2]//div[contains(@class, 'g-i-tile-i-title')]"),
            @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'tile-catalog')][3]//div[contains(@class, 'g-i-tile-i-title')]")
    })
    List<WebElement> deviceName;

    public void clickObtainableSmartphonesLink() {
        this.waitFor(obtainableSmartphonesLink);
        obtainableSmartphonesLink.click();
    }

    public void expandClassBlock() {
        this.waitFor(expandClassBlock);
        expandClassBlock.click();
    }

    public void clickSortingDropdown() {
        this.waitFor(sortingDropdown);
        sortingDropdown.click();
    }

    public void chooseAscendingPriceSorting() {
        this.waitFor(priceAscendingLink);
        priceAscendingLink.click();
    }

    public String getSortingDropdownText() {
        this.waitFor(sortingDropdown);
        return sortingDropdown.getText();
    }

    public void openSecondList() {
        this.waitFor(secondListLink);
        secondListLink.click();
    }

    public void openThirdList() {
        this.waitFor(thirdListLink);
        thirdListLink.click();
    }

    public String getCurrentPageNumber() {
        this.waitFor(currentPageNumberBlock);
        return currentPageNumberBlock.getText();
    }

    public String getAllDevicesData() {
        String data = "";
        SmartphonesPage smartphonesPage = new SmartphonesPage();
        data = data + smartphonesPage.getDevicesData();
        this.setDevicesDataToDB();
        smartphonesPage.openSecondList();
        data = data + smartphonesPage.getDevicesData();
        this.setDevicesDataToDB();
        smartphonesPage.openThirdList();
        data = data + smartphonesPage.getDevicesData();
        this.setDevicesDataToDB();
        return data;
    }

    public String getDevicesData() {
        String data = "";
        String[] arrayData = new String[3];
        SmartphonesPage smartphonesPage = new SmartphonesPage();
        data = smartphonesPage.getCurrentPageNumber() + " страница";
        for (int i = 0; i < 3; i++) {
            arrayData[i] = "Название: " + deviceName.get(i).getText() + " Цена: " + devicePrice.get(i).getText();
            int number = i + 1;
            data = data + "\n" + number + " устройство: " + arrayData[i];
        }
        return data + "\n\n";
    }

    public void setDevicesDataToDB(){
        String idString;
        String name;
        String price;
        for (int i = 0; i < 3; i++){
            id++;
            idString = Integer.toString(id);
            name = deviceName.get(i).getText();
            price = devicePrice.get(i).getText();

            DBHelper dbHelper = new DBHelper();
            dbHelper.setDBTableData(idString, name, price);
        }
    }

    public void writeDataIntoFile(String text) {
        try {
            String filePath = "src/test/java/files/devicesData.txt";
            String fileAbsolutePath;
            File newFile = new File(filePath);
            newFile.createNewFile();
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
            fileAbsolutePath = newFile.getAbsolutePath();
            System.out.println("File was saved at: " + fileAbsolutePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProductCartPage clickFirstProduct(){
        this.waitFor(firstDeviceButton);
        firstDeviceButton.click();
        return new ProductCartPage();
    }
}
