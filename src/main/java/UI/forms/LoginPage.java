package UI.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    private static final String BASE_URL = "https://www.onliner.by";

    @FindBy(xpath = ".//*[@id='userbar']")
    private WebElement user_authentification_form;

    @FindBy(css = "input.auth-box__input")
    private WebElement auth_box;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement pass;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement button;

    @FindBy(linkText = "Выйти")
    private WebElement linkText;

    @FindBy(linkText = "1941936")
    private WebElement automation_test1;

    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    /**
     * Go in with your username and password
     */
    public void logIn(String username, String password) {
        user_authentification_form.click();
        auth_box.clear();
        auth_box.sendKeys(username);
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        button.click();
    }

    /**
     * Entering your login and password
     */
    public void logOut(String username, String password){
        user_authentification_form.click();
        auth_box.clear();
        auth_box.sendKeys(username);
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        button.click();
        linkText.click();
    }
    /**
     * Checking compliance with the login
     */
    public boolean isLogout(){
        boolean logOutIsTrue=false;
        if(driver.findElement(By.cssSelector("div.auth-bar__item.auth-bar__item--text")).isDisplayed()) logOutIsTrue=true;
        return  logOutIsTrue;
    }

    public boolean isLogin(){
        return automation_test1.isDisplayed();
    }
}