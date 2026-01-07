package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * This class represents testing products cart functionality.
 */
public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.isPageLoaded("Products");
        productPage.setAddToCart("Test.allTheThings() T-Shirt (Red)");
        productPage.setAddToCart("Sauce Labs Bolt T-Shirt");
        productPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 2);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
