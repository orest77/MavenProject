package Tools;

import Data.IApplicationSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class FirefoxBrowser implements Browser {
    @Override
    public WebDriver GetBrowser(IApplicationSource applicationSource) {
        File file = new File("D:\\Chrome\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        if (applicationSource.GetBrowserOptions() != null)
        {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(applicationSource.GetBrowserOptions());
            return new FirefoxDriver(options);
        }
        else
        {
            return new FirefoxDriver();
        }
    }
}
