package pages;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 16.11.2016.
 */
public class RozetkaStartPage {

    public RozetkaStartPage() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-title='Телефоны, ТВ и электроника']")
    WebElement phonesTvLink;

    @FindBy (xpath = "//a[.='Телефоны']")
    WebElement phonesLink;

    public void clickPhoneTVSection() {
        Helper helper = new Helper();
        helper.waitForElement(phonesTvLink);
        phonesTvLink.click();
    }

    public PhonesPage clickPhonesSection() {
        Helper helper = new Helper();
        helper.waitForElement(phonesLink);
        phonesLink.click();
        return new PhonesPage();
    }
}
