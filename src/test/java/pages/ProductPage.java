package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    WebDriver driver;
    By pageTitle = By.xpath("//*[@data-test='title']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).isDisplayed();
    }
}
