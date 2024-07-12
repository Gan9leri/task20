package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private static final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);
    private static final AuthConfig authConfig = ConfigFactory.create((AuthConfig.class));

    public WebDriver getDriver() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", authConfig.browserstackUser());
        caps.setCapability("browserstack.key", authConfig.browserstackKey());
        caps.setCapability("app", config.browserstackApp());
        caps.setCapability("device", config.browserstackDevice());
        caps.setCapability("os_version", config.browserstackOsVersion());
        caps.setCapability("project", config.browserstackProject());
        caps.setCapability("build", config.browserstackBuild());
        caps.setCapability("name", config.browserstackName());
        try {
            return new RemoteWebDriver(
                    new URL(config.browserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities){
        return getDriver();
    }
}