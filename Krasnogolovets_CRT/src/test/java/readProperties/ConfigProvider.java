package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String USER_1_NAME = readConfig().getString("userParams.user1.name");
    String USER_1_PASS = readConfig().getString("userParams.user1.password");
    String USER_1_EMAIL = readConfig().getString("userParams.user1.email")+ (int) (Math.random()*100);

    String USER_2_NAME = readConfig().getString("userParams.user2.name");
    String USER_2_PASS = readConfig().getString("userParams.user2.password");
    String USER_2_EMAIL = readConfig().getString("userParams.user2.email")+ (int) (Math.random()*100);

    String USER_3_NAME = readConfig().getString("userParams.user3.name");
    String USER_3_PASS = readConfig().getString("userParams.user3.password");
    String USER_3_EMAIL = readConfig().getString("userParams.user3.email")+ (int) (Math.random()*100);

    String USER_4_NAME = readConfig().getString("userParams.user4.name");
    String USER_4_PASS = readConfig().getString("userParams.user4.password");
    String USER_4_EMAIL = readConfig().getString("userParams.user4.email")+ (int) (Math.random()*100);

    String USER_5_NAME = readConfig().getString("userParams.user5.name");
    String USER_5_PASS = readConfig().getString("userParams.user5.password");
    String USER_5_EMAIL = readConfig().getString("userParams.user5.email")+ (int) (Math.random()*100);

    String USER_NO_AT_EMAIL = readConfig().getString("userParams.userWithoutAt.email");

    String USER_WITH_SYMBOLS_NAME = readConfig().getString("userParams.userWithSymbols.name");
    String USER_WITH_SYMBOLS_EMAIL = readConfig().getString("userParams.userWithSymbols.email");
    String USER_WITH_SYMBOLS_PASS = readConfig().getString("userParams.userWithSymbols.password");

    String USER_INVALID_NAME = readConfig().getString("userParams.userInvalid.name");
    String USER_INVALID_EMAIL = readConfig().getString("userParams.userInvalid.email");
    String USER_INVALID_PASS = readConfig().getString("userParams.userInvalid.password");




}