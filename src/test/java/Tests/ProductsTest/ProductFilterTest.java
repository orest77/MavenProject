package Tests.ProductsTest;

import Logic.Logic;
import org.junit.Assert;
import org.junit.Test;

public class ProductFilterTest extends ATestRunner {


    @Test
    public void productFilterTest() {
        //Arrange
        String forPrice = "19000";
        String toPrice = "50000";
        String brand = "Acer";
        String modelCPU = "Core i7-9750H";
        String ram = "16 ГБ";
        String driver = "SSD";
        Logic logic = new Logic();

        //Act
        //Step 1 Go tu URL and click laptop button
        boolean actualResult = logic.goToLaptopPage().isDisplayedInfoTitle();
        //Assert
        Assert.assertTrue(actualResult);

        //Step 2  Choose price, brand , model core, ram memory and hard disk
        boolean actualResult1 = logic.configurFilterForProduct(forPrice, toPrice, brand, modelCPU
                ,ram, driver).CheckAllProductByName(brand);
        System.out.println(actualResult1);
        //Assert
        Assert.assertTrue(actualResult1);

    }
}
