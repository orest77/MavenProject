package Tests.ProductsTest;

import Logic.Logic;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToBasketTest extends ATestRunner {


    @Test
    public void addProductOfBasketTest() {
        //Arrange
        String codeIDExpected = "Код: 1342821";
        String productName = "Ноутбук игровой Acer Nitro 5 AN515-52-50Z0 (NH.Q3MEU.004)";
        String countProducts = "1";
        Logic mainPage = new Logic();

        //Step 1 Go to url
        boolean actualResult = mainPage.goToUrlAndVerifyByImg();
        //Assert
        Assert.assertTrue(actualResult);

        //Step 2 Go to laptop page and click buy
        String actualResult1 = mainPage.clickButtonBuyAndVerifyBasketPage(productName);
        //Assert
        Assert.assertEquals(codeIDExpected, actualResult1);

        //Close Page an verify basket list it's  button on search bar
        String actualResult2 = mainPage.addProductToBasketListAndGetString();
        //Assert
        Assert.assertEquals(actualResult2, countProducts);

    }
}
