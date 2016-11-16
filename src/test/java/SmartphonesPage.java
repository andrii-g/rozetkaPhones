import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'g-price-uah')]")
    WebElement devicePrice;

    @FindBy(xpath = "//div[contains(@class, 'tile-catalog')]//div[contains(@class, 'g-i-tile-i-title')]")
    WebElement deviceName;

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
        String price = devicePrice.getText();
        String name = deviceName.getText();
        return price + name;
    }

    public void openSecondList() {
        secondListLink.click();
    }

    public void openThirdList() {
        thirdListLink.click();
    }
}
