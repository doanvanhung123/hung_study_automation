package actions.utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config {
    @Key("App.Url")
    String appUrl();
    @Key("App.User")
    String appUserName();

    @Key("App.Pass")
    String appPassword();

    @Key("DB.Host")
    String dbHostname();

    @Key("DB.User")
    String dbUser();

    @Key("DB.Pass")
    String dbPass();


}
