package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:GooglePixel6.properties"
})

public interface BrowserStackConfig extends Config {

    String browserstackApp();
    String browserstackDevice();
    String browserstackOsVersion();
    String browserstackProject();
    String browserstackBuild();
    String browserstackName();
    String browserstackUrl();

}