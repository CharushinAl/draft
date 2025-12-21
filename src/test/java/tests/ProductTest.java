package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * This class represents functionality related to testing the storefront and shopping cart.
 */

public class ProductTest extends BaseTest {
    @Test
    public void checkGoodsAdded() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.isPageLoaded("Products");
        productPage.setAddToCart("Test.allTheThings() T-Shirt (Red)");
        productPage.setAddToCart("Sauce Labs Bolt T-Shirt");
        productPage.setAddToCart(3);

        assertEquals(Integer.parseInt(productPage.checkGoodsQuantity()), 3);
        assertEquals(productPage.checkGoodsQuantityGetAttribute(), "shopping-cart-badge");
        Thread.sleep(10000);
    }
}
