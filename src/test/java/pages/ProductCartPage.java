package pages;

import helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrii_Grygoruk on 11/24/2016.
 */
public class ProductCartPage {
    public ProductCartPage(){
        PageFactory.initElements(BasePage.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class, 'g-kit-slider-i')]//h3[contains(text(), 'Вместе дешевле')]")
    WebElement recommendationBlock;

    public String getRecommendationBlockText(){
        Helper helper = new Helper();
        helper.waitForElement(recommendationBlock);
        return recommendationBlock.getText();
    }
}
