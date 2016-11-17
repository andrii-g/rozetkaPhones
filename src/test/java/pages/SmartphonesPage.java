package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by User on 16.11.2016.
 */
public class SmartphonesPage {
    private WebDriver driver;

    public SmartphonesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public void clickObtainableSmartphonesLink(){
        obtainableSmartphonesLink.click();
    }

    public void clickSortingDropdown(){
        sortingDropdown.click();
    }

    public void chooseAscendingPriceSorting(){
        priceAscendingLink.click();
    }

    public String getSortingDropdownText(){
        return sortingDropdown.getText();
    }

    public String getDevicesData() {
        String data = "";
        String[] arrayData = new String[3];
        for (int i = 0; i < 3; i++) {
            arrayData[i] = "Название: " + deviceName.get(i).getText() + " Цена: " + devicePrice.get(i).getText();
            int number = i + 1;
            data = data + "\n" + number + " устройство: " + arrayData[i];
        }
        return data;
    }

    public void openSecondList() {
        secondListLink.click();
    }

    public void openThirdList() {
        thirdListLink.click();
    }
}
