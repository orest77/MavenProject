package Pages.Header;

import Pages.ProductPages.BasketProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchBar extends TopBar {

    private WebElement menuButton;
    private WebElement foundForBrand;
    private WebElement searchBox;
    private WebElement searchButton;
    private WebElement signInButton;
    private WebElement comparable;
    private WebElement basketListButton;

    public SearchBar(WebDriver driver) {
        super(driver);
        initWebElements();
    }

    private void initWebElements() {
        menuButton = driver.findElement(By.id("menuLink"));
        foundForBrand = driver.findElement(By.cssSelector(".header-brands__lbl"));
        searchBox = driver.findElement(By.id("searchTop"));
        searchButton = driver.findElement(By.id("searchButtonTop"));
        signInButton = driver.findElement(By.id("headerProfileContent"));
        comparable = driver.findElement(By.id("headerCompareLink"));
        basketListButton = driver.findElement(By.id("cartHeaderQty"));
    }

    public void clickAndHoldMenuButton() {
        Actions action = new Actions(driver);
        action.clickAndHold(menuButton).build().perform();
    }

    public void clickFoundForBrand() {
        foundForBrand.click();
    }

    public void clickClearEnterTextForSearchBox(String text) {
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickComparableButton() {
        comparable.click();
    }

    public String getTextBasketListButton() {
        return basketListButton.getAttribute("data-count");
    }

    public BasketProduct clickBasketListButton() {
        basketListButton.click();
        return new BasketProduct(driver);
    }
}
