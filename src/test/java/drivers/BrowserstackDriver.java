package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final BrowserstackConfig config;

    public BrowserstackDriver(BrowserstackConfig config) {
        this.config = config;
    }

    public WebDriver getDriver() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", config.browserstackUser());
        caps.setCapability("browserstack.key", config.browserstackKey());
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
