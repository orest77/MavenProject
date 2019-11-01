package Data;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class ApplicationSource implements ISetBrowserName, ISetImplicitWaitTimeOut, ISetExplicitTimeOut,
        ISetBaseUrl, ISetLoginUrl, ISetLogoutUrl, IApplicationSourceBuild, IApplicationSource {
    //Browser data
    private String _browserName;
    //Implicit and Explicit waits
    private long _implicitWaitTimeOut;
    private long _explicitTimeOut;
    // Remote
    private URL _url;
    private Map<String, Object> _capabilities;
    private List<String> _browserOptions;
    //URLs
    private String _baseUrl;
    private String _loginUrl;
    private String _logoutUrl;

    public static ISetBrowserName Get() {
        return new ApplicationSource();
    }

    @Override
    public ISetImplicitWaitTimeOut SetBrowserName(String browsersName) {
        _browserName = browsersName;
        return this;
    }

    @Override
    public ISetExplicitTimeOut SetImplicitWaitTimeOut(long implicitWaitTimeOut) {
        _implicitWaitTimeOut = implicitWaitTimeOut;
        return this;
    }

    @Override
    public ISetBaseUrl SetExplicitTimeOut(long explicitTime) {
        _explicitTimeOut = explicitTime;
        return this;
    }

    @Override
    public ISetLoginUrl SetBaseUrl(String baseUrl) {
        _baseUrl = baseUrl;
        return this;
    }

    @Override
    public ISetLogoutUrl SetLoginUrl(String loginUrl) {
        _loginUrl = loginUrl;
        return this;
    }

    @Override
    public IApplicationSourceBuild SetLogoutUrl(String logoutUrl) {
        _logoutUrl = logoutUrl;
        return this;
    }

    @Override
    public IApplicationSourceBuild SetBrowserOptions(List<String> browserOptions) {
        _browserOptions = browserOptions;
        return this;
    }

    @Override
    public IApplicationSourceBuild SetCapabilities(Map<String, Object> capabilities) {
        _capabilities = capabilities;
        return this;
    }

    @Override
    public IApplicationSourceBuild SetUrl(URL url) {
        _url = url;
        return this;
    }

    @Override
    public IApplicationSource Build() {
        return this;
    }

    @Override
    public String GetBrowserName() {
        return _browserName;
    }

    @Override
    public long GetImplicitWaitTimeOut() {
        return _implicitWaitTimeOut;
    }

    @Override
    public long GetExplicitTimeOut() {
        return _explicitTimeOut;
    }

    @Override
    public URL GetUrl() {
        return _url;
    }

    @Override
    public Map<String, Object> GetCapabilities() {
        return _capabilities;
    }

    @Override
    public List<String> GetBrowserOptions() {
        return _browserOptions;
    }

    @Override
    public String GetBaseUrl() {
        return _baseUrl;
    }

    @Override
    public String GetLoginUrl() {
        return _loginUrl;
    }

    @Override
    public String GetLogoutUrl() {
        return _logoutUrl;
    }
}
