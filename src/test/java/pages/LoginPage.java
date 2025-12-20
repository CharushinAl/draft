package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By userNameField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[id='password']");
    By loginButton = By.cssSelector("[id='login-button']");
    By errorText = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
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
