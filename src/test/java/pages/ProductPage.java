package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the functionality of the pages with a product showcase and cart.
 */
public class ProductPage extends BasePage {
    // By pageTitle = By.xpath("//*[@data-test='title']");
    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    // private static final String DATA_TEST_PATTERN = "//*[@data-test='%s']";
    private static final String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void setAddToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    public void setAddToCart(final int goodsIndex) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsIndex).click();
    }

    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    public void switchToCart() {
        driver.findElement(cartBadge).click();
    }

    public String checkGoodsQuantityGetAttribute() {
        return driver.findElement(cartBadge).getDomAttribute("data-test");
    }
}
