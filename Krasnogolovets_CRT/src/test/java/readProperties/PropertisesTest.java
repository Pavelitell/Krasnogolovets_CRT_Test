package readProperties;

import org.junit.jupiter.api.Test;

import static readProperties.ConfigProvider.USER_1_EMAIL;

public class PropertisesTest {
    @Test
    public void readFromConf() {
        System.out.println(USER_1_EMAIL);
    }

}
