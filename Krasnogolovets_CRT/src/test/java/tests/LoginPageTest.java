package tests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignUpPage;

import static readProperties.ConfigProvider.*;
public class LoginPageTest extends BaseTest {
    SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage =new ProfilePage();
    HomePage homePage = new HomePage();

    @BeforeEach
    public void logIn()  {
        homePage.logIn();
    }
    @Test
    public void logInInvalidUser() {
        loginPage.signIn(USER_INVALID_EMAIL, USER_INVALID_PASS);
        //Проверяем что остаеться на той же странице и не переход на авторизацию
        Assertions.assertEquals("Login", loginPage.getLogintitle());
    }
}
