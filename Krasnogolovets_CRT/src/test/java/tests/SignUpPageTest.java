package tests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignUpPage;

import static readProperties.ConfigProvider.*;

public class SignUpPageTest extends BaseTest {

    SignUpPage signUpPage = new SignUpPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    HomePage homePage = new HomePage();

    @BeforeEach
    public void signIn() {
        homePage.signUp();
    }


    @Test
    public void e2ePositive() {
        signUpPage.trueSignUp(USER_1_NAME, USER_1_EMAIL, USER_1_PASS);
        loginPage.signIn(USER_1_EMAIL, USER_1_PASS);
        Assertions.assertEquals("Welcome," + " " + USER_1_NAME + "!", profilePage.getWelcomeTitle());
    }

    @Test
    public void SignUpWithoutName() {

        signUpPage.withoutNameSignUp(USER_3_PASS, USER_3_EMAIL);
        loginPage.signIn(USER_3_EMAIL, USER_3_PASS);
        Assertions.assertEquals("Welcome," + " " + "!", profilePage.getWelcomeTitle());
    }

    @Test
    public void SignUpWithoutEmail() {
        signUpPage.withoutEmailSignUp(USER_4_NAME, USER_4_PASS);
        Assertions.assertNotEquals("Something like enter email", signUpPage.getDangerWindow());
    }

    @Test
    public void SignUpWithoutPassword() {
        signUpPage.withoutPassSignUp(USER_5_NAME, USER_5_EMAIL);
        Assertions.assertNotEquals("Enter password", signUpPage.getDangerWindow());
    }

    @Test
    public void SingUpEmailWithoutAt() {
        signUpPage.trueSignUp(USER_1_NAME, USER_NO_AT_EMAIL, USER_1_PASS);
        //Проверяем что остаеться на той же странице и не переход на авторизацию
        Assertions.assertEquals("Sign Up", signUpPage.getSignUpTitle());
    }

    @Test
    public void SingUpEmailWithSymbols() {
        signUpPage.trueSignUp(USER_WITH_SYMBOLS_NAME, USER_WITH_SYMBOLS_EMAIL, USER_WITH_SYMBOLS_PASS);
        //Проверяем что остаеться на той же странице и не переход на авторизацию
        Assertions.assertEquals("Sign Up", signUpPage.getSignUpTitle());
    }

    @Test
    public void signInWithRememberMe() {
        signUpPage.trueSignUp(USER_2_NAME, USER_2_EMAIL, USER_2_PASS);
        loginPage.signInWithRememberMe(USER_2_EMAIL, USER_2_PASS);
        profilePage.signOut();
        homePage.logIn();
        loginPage.signIn(USER_2_EMAIL, USER_2_PASS);
        Assertions.assertEquals("Welcome," + " " + USER_2_NAME + "!", profilePage.getWelcomeTitle());
    }
}


