package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By pageTitle = By.xpath("//*[@data-test='title']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}
