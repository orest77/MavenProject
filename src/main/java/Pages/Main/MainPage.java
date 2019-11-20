package Pages.Main;

import Pages.ProductPages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    private WebElement image;
    private WebElement mouse;
    private WebElement keyboard;
    private WebElement laptop;
    private WebElement consoles;
    private WebElement personalComputer;
    private WebElement monitor;
    private WebElement gamePads;
    private WebElement headset;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements() {
        image = driver.findElement(By.xpath("//div[@class='gm-row']//img"));
        mouse = driver.findElement(By.xpath("//a[@href='/gaming-mouse']"));
        keyboard = driver.findElement(By.xpath("//a[@href='/gaming-keyboard']"));
        laptop = driver.findElement(By.xpath("//a[@href='/gaming-laptop']"));
        consoles = driver.findElement(By.xpath("//a[@href='/gaming-consoles']"));
        personalComputer = driver.findElement(By.xpath("//a[@href='/gaming-consoles']"));
        monitor = driver.findElement(By.xpath("//a[@href='/game-monitor']"));
        gamePads = driver.findElement(By.xpath("//a[@href='/gamepades']"));
        headset = driver.findElement(By.xpath("//a[@href='/gaming-headset']"));
    }


    public boolean isDisplayImageGames() {
         return image.isDisplayed();
    }

    public ProductPage clickMouse() {
        mouse.click();
        return new ProductPage(driver);
    }

    public ProductPage clickKeyboard() {
        keyboard.click();
        return new ProductPage(driver);

    }

    public ProductPage clickLaptop() {
        laptop.click();
        return new ProductPage(driver);

    }

    public ProductPage clickConsoles() {
        consoles.click();
        return new ProductPage(driver);

    }

    public ProductPage clickPersonalComputer() {
        personalComputer.click();
        return new ProductPage(driver);

    }

    public ProductPage clickMonitor() {
        monitor.click();
        return new ProductPage(driver);

    }

    public ProductPage clickGamePads() {
        gamePads.click();
        return new ProductPage(driver);

    }

    public ProductPage clickHeadset() {
        headset.click();
        return new ProductPage(driver);

    }
}
