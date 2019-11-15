package Tests.ProductsTest;

import Data.ApplicationSourceRepository;
import Tools.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public abstract class ATestRunner {

    @BeforeClass
    public static void BeforeAllMethods() throws MalformedURLException {
        Application.Get(ApplicationSourceRepository.Get().ChromeMaximizedWithUi());
    }

    @AfterClass
    public static void AfterAllMethods() {

        Application.Remove();
    }

    @BeforeMethod
    public void SetUp() {
        Application.Get().BaseUrlAction();
    }

    @AfterMethod
    public void TearDown() {
        // Logout
        Application.Remove();
    }
}
