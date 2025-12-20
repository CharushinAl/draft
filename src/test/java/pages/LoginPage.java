package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the functionality of the page with auth form.
 */
public class LoginPage extends BasePage {
    By userNameField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[id='password']");
    By loginButton = By.cssSelector("[id='login-button']");
    By errorText = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String userName, String password) {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageAppear() {
        return driver.findElement(errorText).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorText).getText();
    }
}
