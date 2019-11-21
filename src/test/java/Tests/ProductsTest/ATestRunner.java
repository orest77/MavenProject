package Tests.ProductsTest;

import Data.ApplicationSourceRepository;
import Pages.Main.MainPage;
import Tools.Application;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public abstract class ATestRunner {

    @BeforeClass
    public static void BeforeAllMethods() throws MalformedURLException {
        Application.Get(ApplicationSourceRepository.Get().ChromeMaximizedWithUi());
    }

    @BeforeMethod
    public void SetUp() {
        BaseUrlAction();
    }

    @AfterTest
    public void TearDown() {
        // Logout
        Application.Remove();
    }

    private void BaseUrlAction() {
        Application.Get().getBrowser().OpenUrl(Application.Get()
                .getApplicationSource()
                .GetBaseUrl());
        new MainPage(Application.Get()
                .getBrowser()
                .Driver);
    }
}
