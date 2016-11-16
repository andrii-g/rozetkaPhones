import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 16.11.2016.
 */
public class RozetkaStartPage {
    private WebDriver driver;

    public RozetkaStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-title='Телефоны, ТВ и электроника']")
    WebElement phonesTvLink;

    @FindBy (xpath = "//a[.='Телефоны']")
    WebElement phonesLink;

    public void clickPhoneTVSection() {
        phonesTvLink.click();
    }

    public PhonesPage clickPhonesSection() {
        phonesLink.click();
        return new PhonesPage(driver);
    }
}
