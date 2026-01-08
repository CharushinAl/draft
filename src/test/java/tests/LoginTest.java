package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * This class represents testing auth form functionality.
 */
public class LoginTest extends BaseTest {
    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(description = "Checking for invalid input data", priority = 1, dataProvider = "invalidData")
    public void checkInvalidInput(String userName, String userPassword, String errMsg) {
        loginPage.open();
        loginPage.login(userName, userPassword);

        assertTrue(loginPage.isErrorMessageAppear(), "Error message doesn't appear");
        assertEquals(loginPage.getErrorMessageText(), errMsg);
    }

    @Test(description = "Checking for valid input data", priority = 2)
    public void checkLogin() {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(productPage.isPageLoaded("Products"), "Register btn isn't visible");
    }
}
