package Data;

import java.net.URL;
import java.util.List;
import java.util.Map;

public interface IApplicationSourceBuild {
    IApplicationSourceBuild SetBrowserOptions(List<String> browserOptions);

    IApplicationSourceBuild SetCapabilities(Map<String, Object> capabilities);

    IApplicationSourceBuild SetUrl(URL url);

    IApplicationSource Build();
}
