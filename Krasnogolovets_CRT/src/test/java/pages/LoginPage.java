package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input [@placeholder='Your Email']")
    private WebElement YourEmailTextBox;
    @FindBy(xpath = "//input [@placeholder='Your Password']")
    private WebElement YourPassTextBox;
    @FindBy(xpath = "//button[@class = 'button is-block is-info is-large is-fullwidth']")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@type='checkbox']")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//*[@class='title']")
    public WebElement loginTitle;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String getLogintitle() {
        return loginTitle.getText();
    }

    public LoginPage signIn(String email, String password) {

        YourEmailTextBox.sendKeys(email);
        YourPassTextBox.sendKeys(password);
        signInButton.click();
        return this;
    }

    public LoginPage signInWithRememberMe(String email, String password) {

        YourEmailTextBox.sendKeys(email);
        YourPassTextBox.sendKeys(password);
        rememberMeCheckbox.click();
        signInButton.click();
        return this;
    }
}