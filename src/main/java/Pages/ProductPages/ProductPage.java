package Pages.ProductPages;

import Pages.Header.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends ConfigFilter {

    private WebElement infoTitle;
    private WebElement productsCount;
    private WebElement displayThreeColumns;
    private WebElement displayFourColumns;
    private WebElement displayList;
    protected List<ProductItems> productItem;

    public ProductPage(WebDriver driver) {
        super(driver);
        initWebElements();
    }

    private void initWebElements() {
        infoTitle = driver.findElement(By.cssSelector(".category-info__title"));
        productsCount = driver.findElement(By.id("productsCount"));
        displayThreeColumns = driver.findElement(By.xpath("(//div[@id='categoryToolbar']//div[@class='tooltip'])[1]"));
        displayFourColumns = driver.findElement(By.xpath("(//div[@id='categoryToolbar']//div[@class='tooltip'])[2]"));
        displayList = driver.findElement(By.xpath("(//div[@id='categoryToolbar']//div[@class='tooltip'])[3]"));
        productItem = InitializeListSearchResult(driver.findElements(By.cssSelector(".product-item__i")));
    }

    public List<ProductItems> InitializeListSearchResult(List<WebElement> elements) {
        List<ProductItems> list = new ArrayList<ProductItems>();
        for (WebElement current : elements) {
            list.add(new ProductItems(current));
        }
        return list;
    }

    public List<ProductItems> getListSearchResult() {
        return productItem;
    }

    public ProductItems findAppropriateLink(String product) {

        for (ProductItems item : productItem) {
            if (item.IsAppropriate(product)) {
                return item;
            }
        }
        return null;
    }

    public String getProductName(String prodName) {
        return findAppropriateLink(prodName).getTextProductName();
    }

    public BasketProduct clickBuyButton(String prodName) {
        findAppropriateLink(prodName).clickBuyProductButton();
        return new BasketProduct(driver);
    }

    public boolean isDisplayedInfoTitle() {
        return infoTitle.isDisplayed();
    }

    public String getTextInfoTitle() {
        return infoTitle.getText();
    }

    public String getTextProductsCount() {
        return productsCount.getText();
    }

    public ProductPage clickDisplayThreeColumns() {
        displayThreeColumns.click();
        return this;
    }

    public ProductPage clickDisplayFourColumns() {
        displayFourColumns.click();
        return this;
    }

    public ProductPage clickDisplayList() {
        displayList.click();
        return this;
    }

    public Boolean CheckAllProductByName(String name) {
        for (ProductItems item : productItem) {
            if (item.CheckByName(name)) {
                return true;
            }
        }
        return false;
    }


    public String GetTextBasket() {
        return new SearchBar(driver).getTextBasketListButton();
    }
}
