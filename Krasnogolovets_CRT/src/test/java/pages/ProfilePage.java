package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

    @FindBy(xpath= "/html/body/section/div[2]/div/h1")
    private WebElement welcomeTitle;

    @FindBy(xpath = "//*[@id='navbarMenuHeroA']/div/a[3]")
    private WebElement loginOutButton;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public ProfilePage signOut(){
        loginOutButton.click();
        return this;
    }
    public String getWelcomeTitle(){
        return welcomeTitle.getText();
    }

}
