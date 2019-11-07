package Tests.ProductsTest;

import Data.ApplicationSourceRepository;
import Tools.Application;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public abstract class ATestRunner {

    @BeforeClass
    public static void BeforeAllMethods() {
        Application.Get(ApplicationSourceRepository.Get().ChromeMaximizedWithUi());
    }

    @AfterClass
    public static void AfterAllMethods() {

        Application.Remove();
    }

    @Before
    public void SetUp() {
        Application.Get().BaseUrlAction();
    }

    @After
    public void TearDown() {
        // Logout
        Application.Remove();
    }
}
