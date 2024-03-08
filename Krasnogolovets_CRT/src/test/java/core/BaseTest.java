package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.ProfilePage;


import static helpers.StringModifire.getUniqueString;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

abstract public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);
        driver.manage().timeouts().implicitlyWait(15, SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterEach
    public void cleanPage() {
        ProfilePage profilePage = new ProfilePage();

        profilePage.signOut();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}

//        Assertions.assertTrue(homePage.getHomeTitle());
//        HomePage homePage = new HomePage();