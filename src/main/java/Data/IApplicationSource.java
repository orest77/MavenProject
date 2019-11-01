package Data;

import java.net.URL;
import java.util.List;
import java.util.Map;

public interface IApplicationSource {
    String GetBrowserName();

    long GetImplicitWaitTimeOut();

    long GetExplicitTimeOut();

    URL GetUrl();

    Map<String, Object> GetCapabilities();

    List<String> GetBrowserOptions();

    String GetBaseUrl();

    String GetLoginUrl();

    String GetLogoutUrl();
}
