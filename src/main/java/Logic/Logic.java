package Logic;

import Pages.Main.MainPage;
import Pages.ProductPages.BasketProduct;
import Pages.ProductPages.ConfigFilter;
import Pages.ProductPages.ProductPage;
import Tools.Application;
import org.openqa.selenium.WebDriver;

public class Logic {

    public Boolean goToUrlAndVerifyByImg() {
        MainPage mainPage = new MainPage(Application.Get().getBrowser().Driver);
        return mainPage.clickLaptop().isDisplayedInfoTitle();
    }

    public BasketProduct clickButtonBuy(String productName) {
        return new ProductPage(Application.Get().getBrowser().Driver).clickBuyButton(productName);
    }

    public String clickButtonBuyAndVerifyBasketPage(String productName) {
        return clickButtonBuy(productName).getCodeProduct();
    }

    public ProductPage clickButtonClosePage() {
        return new BasketProduct(Application.Get().getBrowser().Driver).clickCloseButton();
    }

    public String addProductToBasketListAndGetString() {
        return clickButtonClosePage().GetTextBasket();
    }

    //Go to laptop page
    public ProductPage goToLaptopPage() {
        MainPage mainPage = new MainPage(Application.Get().getBrowser().Driver);
        return mainPage.clickLaptop();
    }

    public ProductPage configurFilterForProduct(String forPrice, String toPrice, String brand
            , String modelCPU, String RAM, String driver) {
        return new ProductPage(Application.Get().getBrowser().Driver)
                .choosePriceRange(forPrice, toPrice)
                .clickBrand(brand)
                .clickModelCPU(modelCPU)
                .clickAmountOfRAM(RAM)
                .clickTypeDrive(driver)
                .clickShowResult();
    }
}

