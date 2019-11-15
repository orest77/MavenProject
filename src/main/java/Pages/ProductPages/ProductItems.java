package Pages.ProductPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItems {
    protected WebElement current;

    private WebElement productName ;
    private WebElement productBuy ;
    private WebElement productPrice ;

    public ProductItems(WebElement current) {
        this.current = current;
        initWebElements();
    }

    private void initWebElements() {
        productName = current.findElement(By.className("product-item__name"));
        productBuy = current.findElement(By.xpath("//span[@class='buy']"));
        productPrice = current.findElement(By.cssSelector("span.price-value"));
    }

    public String getTextProductName() {
        return productName.getText();
    }

    public ProductItems clickBuyProductButton() {
        productBuy.click();
        return this;
    }

    public String getTextProductPrice() {
        return productPrice.getText();
    }


    public boolean IsAppropriate(String product) {
        return (product.toLowerCase().toLowerCase().trim().equals(getTextProductName().toLowerCase().trim()));
    }

    public boolean CheckByName(String product) {
        return (getTextProductName().toLowerCase().trim().toLowerCase().contains(product.toLowerCase().trim()));
    }
}
