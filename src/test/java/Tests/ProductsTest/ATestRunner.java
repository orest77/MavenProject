package Tests.ProductsTest;

import Data.ApplicationSourceRepository;
import Pages.Main.MainPage;
import Tools.Application;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public abstract class ATestRunner {

    @BeforeClass
    public static void BeforeAllMethods() throws MalformedURLException {
        Application.Get(ApplicationSourceRepository.Get().RemoteLinuxChromeNew());
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

    private MainPage BaseUrlAction() {
        Application.Get().getBrowser().OpenUrl(Application.Get()
                .getApplicationSource()
                .GetBaseUrl());
        return new MainPage(Application.Get()
                .getBrowser()
                .Driver);
    }
}
