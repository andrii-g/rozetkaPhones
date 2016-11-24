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

    @FindBy(xpath = "//div[@id='cart-popup']//h3[contains(text(), 'Вместе дешевле')]")
    WebElement recommendationBlock;

    @FindBy(xpath = "//div[@id='detail_buy_label']//span[contains(@class, 'btn-link-green')]//button[@name='topurchases']")
    WebElement buyButton;

    public String getRecommendationBlockText(){
        Helper helper = new Helper();
        helper.waitForElement(recommendationBlock);
        return recommendationBlock.getText();
    }

    public void clickBuyButton(){
        Helper helper = new Helper();
        helper.waitForElement(buyButton);
        buyButton.click();
    }
}
