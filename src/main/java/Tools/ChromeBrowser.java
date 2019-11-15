package Tools;

import Data.IApplicationSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser implements Browser {
    @Override
    public WebDriver GetBrowser(IApplicationSource applicationSource) {
        File file = new File(CONST.PATH_WINDOWS_CHROME_DRIVER);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        if (applicationSource.GetBrowserOptions() != null)
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(applicationSource.GetBrowserOptions());
            return new ChromeDriver(options);
        }
        else
        {
            return new ChromeDriver();
        }
    }
}
