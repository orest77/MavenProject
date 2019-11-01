package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketProduct {

    protected WebDriver driver;

    private List<WebElement> goods;
    private WebElement codeProduct;
    private WebElement closeButton;

    public BasketProduct(WebDriver driver) {
        this.driver = driver;
        goods = driver.findElements(By.cssSelector("ul.minicart-popup-list li.minicart-popup-item"));
        codeProduct = driver.findElement(By.cssSelector("span.minicart-popup-item__sku"));
        closeButton = driver.findElement(By.xpath("//a[@title='Close']"));
    }


    public String getCodeProduct(){
        return codeProduct.getText();
    }

    public boolean isAppropriate(String name) {
        boolean isContains = true;
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getText().equals(name)) {
                isContains = true;
            } else {
                isContains = false;
            }
        }
        return isContains;
    }

    public String getTextProduct(String name) {
        String text = "";
        if (isAppropriate(name)) {
            text = codeProduct.getText();
        }
        return text;
    }

    public ProductPage clickCloseButton() {
        closeButton.click();
        return new ProductPage(driver);
    }
}
