package Data;

import Tools.CONST;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ApplicationSourceRepository {
    private static volatile ApplicationSourceRepository _instance;

    public static ApplicationSourceRepository Get() {
        if (_instance == null) {
            synchronized (ApplicationSourceRepository.class) {
                if (_instance == null)
                    _instance = new ApplicationSourceRepository();
            }
        }
        return _instance;
    }

    public IApplicationSource Default() {
        return ChromeWithUi();
    }

    public IApplicationSource ChromeWithUi() {
        return ApplicationSource.Get()
                .SetBrowserName(CONST.CHROME_BROWSER)
                .SetImplicitWaitTimeOut(15l)
                .SetExplicitTimeOut(10L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .Build();

    }

    public IApplicationSource FirefoxWithUi() {
        return ApplicationSource.Get()
                .SetBrowserName(CONST.FIREFOX_BROWSER)
                .SetImplicitWaitTimeOut(10L)
                .SetExplicitTimeOut(10L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .Build();
    }

    public IApplicationSource ChromeMaximizedWithUi() {
        List<String> options = new ArrayList<String>();
        options.add("--start-maximized");
        options.add("--no-proxy-server");
        options.add("--ignore-certificate-errors");

        return ApplicationSource.Get()
                .SetBrowserName(CONST.CHROME_BROWSER)
                .SetImplicitWaitTimeOut(15L)
                .SetExplicitTimeOut(15L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .SetBrowserOptions(options)
                .Build();
    }

    public IApplicationSource ChromeWithoutUi() {
        List<String> options = new ArrayList<String>();
        options.add("--headless");
        options.add("--no-proxy-server");
        options.add("--ignore-certificate-errors");

        return ApplicationSource.Get()
                .SetBrowserName(CONST.CHROME_BROWSER)
                .SetImplicitWaitTimeOut(10L)
                .SetExplicitTimeOut(10L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .SetBrowserOptions(options)
                .Build();
    }

    public IApplicationSource RemoteLinuxChromeNew() throws MalformedURLException {
        List<String> options = new ArrayList<String>();
        options.add("--no-sandbox");
        options.add("--display=:99.0");

        Map<String, Object> capabilities = new HashMap<String, Object>();
        capabilities.put("browser", CONST.CHROME_BROWSER);
        capabilities.put(CapabilityType.PLATFORM, "Linux");

        return ApplicationSource.Get()
                .SetBrowserName(CONST.REMOTE_BROWSER)
                .SetImplicitWaitTimeOut(15L)
                .SetExplicitTimeOut(15L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .SetBrowserOptions(options)
                .SetCapabilities(capabilities)
                .SetUrl(new URL(CONST.SELENIUM_HUB))
                .Build();
    }

    public IApplicationSource RemoteChrome() throws MalformedURLException {
        List<String> options = new ArrayList<String>();
        options.add("--headless");
        options.add("--no-gpu");
        options.add("--disable-software-rasterizer");
        options.add("--mute-audio");
        options.add("--hide-scrollbars");

        Map<String, Object> capabilities = new HashMap<String, Object>();
        capabilities.put("browser", CONST.CHROME_BROWSER);
        capabilities.put(CapabilityType.PLATFORM, "Linux");


        return ApplicationSource.Get()
                .SetBrowserName(CONST.REMOTE_BROWSER)
                .SetImplicitWaitTimeOut(15L)
                .SetExplicitTimeOut(15L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .SetBrowserOptions(options)
                .SetCapabilities(capabilities)
                .SetUrl(new URL(CONST.SELENIUM_HUB))
                .Build();

    }

    public IApplicationSource RemoteFirefox() throws MalformedURLException {
        List<String> options = new ArrayList<String>();
        options.add("--headless");
        options.add("--ignore-certificate-errors");
        options.add("--acceptInsecureCerts-false");

        Map<String, Object> capabilities = new HashMap<String, Object>();
        capabilities.put("browser", CONST.FIREFOX_BROWSER);
        capabilities.put(CapabilityType.PLATFORM, "Linux");

        return ApplicationSource.Get()
                .SetBrowserName(CONST.REMOTE_BROWSER)
                .SetImplicitWaitTimeOut(15L)
                .SetExplicitTimeOut(15L)
                .SetBaseUrl(CONST.BASE_URL)
                .SetLoginUrl(CONST.LOGIN_URL)
                .SetLogoutUrl(CONST.LOGOUT_URL)
                .SetBrowserOptions(options)
                .SetCapabilities(capabilities)
                .SetUrl(new URL(CONST.SELENIUM_HUB))
                .Build();
    }

}
