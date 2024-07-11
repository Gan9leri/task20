package config;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {

    Instance;

    private static final BrowserstackConfig config =
            ConfigFactory.create(
                    BrowserstackConfig.class,
                    System.getProperties()
            );

    public BrowserstackConfig read() {
        return config;
    }
}
