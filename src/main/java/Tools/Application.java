package Tools;

import Data.ApplicationSourceRepository;
import Data.IApplicationSource;
import Pages.Header.SearchBar;
import Pages.Main.MainPage;

import java.util.HashMap;
import java.util.Map;

public class Application {

    private static volatile Application _instance;

    public IApplicationSource getApplicationSource() {
        return ApplicationSource;
    }

    public void setApplicationSource(IApplicationSource applicationSource) {
        ApplicationSource = applicationSource;
    }

    public IApplicationSource ApplicationSource;

    private static Map<Long, AllBrowser> _browser = new HashMap<Long, AllBrowser>();

    protected AllBrowser Browser;


    public AllBrowser getBrowser() {
        long currentThread = Thread.currentThread().getId();
        if (!_browser.containsKey(currentThread)) {
            InitBrowser(ApplicationSource);
        }
        return _browser.get(currentThread);
    }

    public Application(IApplicationSource applicationSource) {

        ApplicationSource = applicationSource;
    }
    public static Application Get() {
        return Get(null);
    }

    public static Application Get(IApplicationSource applicationSource) {
        if (_instance == null) {
            synchronized (Application.class) {
                if (_instance == null) {
                    if (applicationSource == null)
                        applicationSource = ApplicationSourceRepository.Get().Default();
                    _instance = new Application(applicationSource);
                }
            }
        }
        return _instance;
    }

    public static void Remove() {
        if (_instance == null)
            return;

        //For parallel work
        long currentThread = Thread.currentThread().getId();
        if (_browser.containsKey(currentThread)) {
            _browser.get(currentThread).Quit();
            _browser.remove(currentThread);
        }

        if (!_browser.isEmpty())
            _instance = null;
    }

    private void InitBrowser(IApplicationSource applicationSource) {
        if (applicationSource == null)
            applicationSource = ApplicationSource;
        _browser.put(Thread.currentThread().getId(), new AllBrowser(applicationSource));
    }

    public MainPage BaseUrlAction() {
        getBrowser().OpenUrl(ApplicationSource.GetBaseUrl());
        return new MainPage(getBrowser().Driver);
    }
}
