package steps;

import UI.forms.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class StepsToReproduced {

    private WebDriver driver;

    @BeforeTest
    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

    /**
     * View your login
     */
    public void loginOnliner(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://www.onliner.by");
        loginPage.logIn(username, password);
    }

    /**
     * Check view your login
     */
    public boolean isLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogin());
    }

    /**
     * Exit login
     */
    public void logoutOnliner(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://www.onliner.by");
        loginPage.logOut(username,password);
    }

    /**
     * Check exit login
     */
    public boolean isLoggedOut() {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogout());
    }

    /**
     * Product search
     */
    public void search(String searcWord){
        Search search = new Search(driver);
        search.openPage("https://www.onliner.by");
        search.search(searcWord);
    }

    /**
     * Check product search
     */
    public boolean isSearched() {
        Search search = new Search(driver);
        return (search.isSearch());
    }

    /**
     * Put the items in the basket
     */
    public void enterBasket(String username, String password) throws InterruptedException {
        EnterBasket enterbasket = new EnterBasket(driver);
        enterbasket.openPage("https://www.onliner.by");
        enterbasket.enterBasket(username,password);
    }

    /**
     * Check put the items in the basket
     */
    public boolean isEnterBasket() {
        EnterBasket enterbasket = new EnterBasket(driver);
        return (enterbasket.isEnterBasket());
    }

    /**
     * Sends a message to another user
     */
    public void sendMessage(String name,String username,String pass,String text){
        SendMessage sendMessage = new SendMessage(driver);
        sendMessage.openPage("https://www.onliner.by");
        sendMessage.sendMessage(name,username,pass,text);
    }
    /**
     * Check that the message has gone
     */
    public boolean isSendMessage() {
        SendMessage sendMessage = new SendMessage(driver);
        return (sendMessage.isSendMessage());
    }

    /**
     * Comparing to the catalog of products
     */
    public void compare(String username,String password,String text) throws InterruptedException {
        Compare compare = new Compare(driver);
        compare.openPage("https://www.onliner.by");
        compare.compare(username,password,text);
    }

    /**
     * Compare products
     */
    public boolean isCompare() {
        Compare compare = new Compare(driver);
        return (compare.isCompare());
    }
}


