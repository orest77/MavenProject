package Pages.Header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class TopBar {

    protected final WebDriver driver;

    private final List<WebElement>navigationButtons;

    private final WebElement telephoneButton ;


    public TopBar(WebDriver driver) {
        this.driver = driver;
        navigationButtons = driver.findElements(By.cssSelector(".header-top #headerLinks a"));
        telephoneButton = driver.findElement(By.xpath("(//a[contains(text(),'0-800-303-505')])[3]"));
    }

    public void clickActionButton() {
        navigationButtons.get(0).click();
    }

    public void clickShopsButton() {
        navigationButtons.get(1).click();
    }

    public void clickDeliveryButton() {
        navigationButtons.get(2).click();
    }

    public void clickFoundOrderButton() {
        navigationButtons.get(3).click();
    }

    public void clickReturnButton() {
        navigationButtons.get(4).click();
    }

    public void clickBlogButton() {
        navigationButtons.get(5).click();
    }

    public void clickTelephoneButton(){
        telephoneButton.click();
    }
}
