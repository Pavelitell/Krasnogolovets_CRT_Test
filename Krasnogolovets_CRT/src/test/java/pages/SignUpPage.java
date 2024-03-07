package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {
    @FindBy(xpath = "//input [@placeholder='Name']") private WebElement nameTextbox;
    @FindBy(xpath = "//input [@placeholder='Email']") private WebElement emailTextbox;
    @FindBy(xpath = "//input [@placeholder='Password']") private WebElement passTextbox;
    @FindBy(xpath = "//button[@class = 'button is-block is-info is-large is-fullwidth']") private WebElement signUpButton;
    @FindBy(xpath = "//*[@class='notification is-danger']") public WebElement dangerWindow;
    @FindBy(xpath = "//*[@class='title']") public WebElement signUpTitle;

    public String getDangerWindow(){
        return dangerWindow.getText();
    }

    public String getSignUpTitle(){
        return signUpTitle.getText();
    }

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }
    public SignUpPage trueSignUp(String name, String email, String password){
        nameTextbox.sendKeys(name);
        emailTextbox.sendKeys(email);
        passTextbox.sendKeys(password);
        signUpButton.click();
        return this;
    }
    public SignUpPage withoutEmailSignUp(String name,  String password){
        nameTextbox.sendKeys(name);
        passTextbox.sendKeys(password);
        signUpButton.click();
        return this;
    }

    public SignUpPage withoutPassSignUp(String name, String email){
        nameTextbox.sendKeys(name);
        emailTextbox.sendKeys(email);
        signUpButton.click();
        return this;
    }
    public SignUpPage withoutNameSignUp(String password, String email){
        emailTextbox.sendKeys(email);
        passTextbox.sendKeys(password);
        signUpButton.click();
        return this;
    }



}
