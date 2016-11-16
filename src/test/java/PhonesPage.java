import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 16.11.2016.
 */
public class PhonesPage {
    private WebDriver driver;

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Смартфоны']")
    WebElement smartphonesLink;

    public SmartphonesPage clickSmartphonesLink() {
        smartphonesLink.click();
        return new SmartphonesPage(driver);
    }

}
