package Tools;

import Data.IApplicationSource;
import org.openqa.selenium.WebDriver;

public interface Browser{
    WebDriver GetBrowser(IApplicationSource applicationSource);
}
