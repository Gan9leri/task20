package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:Auth.properties"
})

public interface AuthConfig extends Config {
    String browserstackUser();
    String browserstackKey();
}
