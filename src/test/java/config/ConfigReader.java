package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {

    Instance;

    private static final BrowserStackConfig config =
            ConfigFactory.create(
                    BrowserStackConfig.class,
                    System.getProperties()
            );

    public BrowserStackConfig read() {
        return config;
    }
}
