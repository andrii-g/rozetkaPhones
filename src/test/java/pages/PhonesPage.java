package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 16.11.2016.
 */
public class PhonesPage {

    public PhonesPage() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Смартфоны']")
    WebElement smartphonesLink;

    public SmartphonesPage clickSmartphonesLink() {
        smartphonesLink.click();
        return new SmartphonesPage();
    }

}
