package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the functionality of the pages with a product showcase and cart.
 */

public class ProductPage extends BasePage {
    By pageTitle = By.xpath("//*[@data-test='title']");
    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void setAddToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }
}
