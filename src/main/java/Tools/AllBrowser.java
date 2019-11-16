package Tools;


import Data.IApplicationSource;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AllBrowser {

    private Map<String, Browser> _browsers = new HashMap<String, Browser>();

    public WebDriver Driver;


    public AllBrowser(IApplicationSource applicationSource) {
        InitBrowsers();
        InitWebDriver(applicationSource);
    }

    private void InitBrowsers() {
        _browsers.put(CONST.CHROME_BROWSER, new ChromeBrowser());
        _browsers.put(CONST.FIREFOX_BROWSER, new FirefoxBrowser());
        _browsers.put(CONST.REMOTE_BROWSER, new RemoteBrowser());
    }


    private void InitWebDriver(IApplicationSource applicationSource) {
        Browser currentBrowser = _browsers.get(CONST.CHROME_BROWSER);

        for (Map.Entry<String, Browser> current : _browsers.entrySet()) {
            if (current.getKey().toLowerCase()
                    .equals(applicationSource.GetBrowserName().toLowerCase())) {
                currentBrowser = current.getValue();
                break;
            }
        }
        Driver = currentBrowser.GetBrowser(applicationSource);
        Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void OpenUrl(String url) {
        Driver.navigate().to(url);
    }

    public void NavigateForward() {
        Driver.navigate().forward();
    }

    public void NavigateBack() {
        Driver.navigate().back();
    }

    public void RefreshPage() {
        Driver.navigate().refresh();
    }

    public void Quit() {
        if (Driver != null) {
            Driver.quit();
            Driver = null;
        }
    }
}
