package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 16.11.2016.
 */
public class RozetkaStartPage extends BasePage{

    public RozetkaStartPage() {
        PageFactory.initElements(BasePage.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-title='Телефоны, ТВ и электроника']")
    WebElement phonesTvLink;

    @FindBy (xpath = "//a[.='Телефоны']")
    WebElement phonesLink;

    public void clickPhoneTVSection() {
        this.waitFor(phonesTvLink);
        phonesTvLink.click();
    }

    public PhonesPage clickPhonesSection() {

        this.waitFor(phonesLink);
        phonesLink.click();
        return new PhonesPage();
    }
}
