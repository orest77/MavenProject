package Tools;

import Data.IApplicationSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;

public class RemoteBrowser implements Browser {
    @Override
    public WebDriver GetBrowser(IApplicationSource applicationSource) {
        Object browser = applicationSource.GetCapabilities().get("browser");
        if (CONST.CHROME_BROWSER.equals(browser)) {
            return RemoteChromeBrowser(applicationSource);
        } else if (CONST.FIREFOX_BROWSER.equals(browser)) {
            return RemoteFirefoxBrowser(applicationSource);
        }
        return null;
    }

    RemoteWebDriver RemoteChromeBrowser(IApplicationSource applicationSource)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(applicationSource.GetBrowserOptions());

        for (Map.Entry<String, Object> capabilities : applicationSource.GetCapabilities().entrySet())
        {
            options.setCapability(capabilities.getKey(),capabilities.getValue());
        }
        return new RemoteWebDriver(applicationSource.GetUrl(), options);
    }

    RemoteWebDriver RemoteFirefoxBrowser(IApplicationSource applicationSource)
    {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(applicationSource.GetBrowserOptions());

        for (Map.Entry<String, Object> capabilities : applicationSource.GetCapabilities().entrySet())
        {
            options.setCapability(capabilities.getKey(),capabilities.getValue());
        }
        return new RemoteWebDriver(applicationSource.GetUrl(), options);
    }
}
