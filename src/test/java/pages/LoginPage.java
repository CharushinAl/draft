package pages;

import io.qameta.allure.Step;
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

    @Step("Открытие страницы")
    public void open() {
        driver.get(BASE_URL);
    }

    // public void open(String url) { driver.get(BASE_URL + url); }

    @Step("Авторизация под кредами пользователя")
    public void login(String userName, String password) {
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Отображение сообщения об ошибке")
    public boolean isErrorMessageAppear() {
        return driver.findElement(errorText).isDisplayed();
    }

    @Step("Получение текста сообщения об ошибке")
    public String getErrorMessageText() {
        return driver.findElement(errorText).getText();
    }
}
