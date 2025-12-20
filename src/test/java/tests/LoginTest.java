package tests;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void checkLockedLogin () {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorMessageAppear(), "Error message doesn't appear");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkLogin () {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productPage.isPageLoaded(), "PumPum");
    }

}
