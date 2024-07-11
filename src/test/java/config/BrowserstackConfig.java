package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:GooglePixel6.properties"
})

public interface BrowserstackConfig extends Config {

    String browserstackUser();
    String browserstackKey();
    String browserstackApp();
    String browserstackDevice();
    String browserstackOsVersion();
    String browserstackProject();
    String browserstackBuild();
    String browserstackName();
    String browserstackUrl();
}