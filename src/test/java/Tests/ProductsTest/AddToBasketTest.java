package Tests.ProductsTest;

import Logic.Logic;
import org.junit.Assert;
import org.junit.Test;

public class AddToBasketTest extends ATestRunner {

    @Test
    public void AddProductOfBasketTest() {
        //Arrange
        String codeIDExpected = "Код: 1342821";
        String productName = "Ноутбук игровой Acer Nitro 5 AN515-52-5601 (NH.Q3LEU.074) Shale Black";
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
        Assert.assertEquals(countProducts,actualResult2);

    }
}
