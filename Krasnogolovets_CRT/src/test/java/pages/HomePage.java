package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class HomePage extends BasePage {

    @FindBy(id = "h1")
    private WebElement title;

    @FindBy(xpath = "//*[@id='navbarMenuHeroA']/div/a[2]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='navbarMenuHeroA']/div/a[3]")
    private WebElement signUpButton;


    public HomePage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public HomePage signUp() {
        signUpButton.click();
        return this;
    }

    public HomePage logIn() {
        loginButton.click();
        return this;
    }

    public boolean getHomeTitle() {
        return title.getText().equals("Test home page");
    }


}
