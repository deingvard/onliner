package tests;

import steps.StepsToReproduced;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoTests {

    private StepsToReproduced stepsToReproduced;
    private static final String USERNAME = "1941936";
    private static final String PASSWORD = "12345678";
    private static final String NAME = "automation_test";
    private static final String SEARCH_PRODUCT = "iPhone";
    private static final String TEXT = "My test automation";


    @BeforeMethod(description = "Init Browser")
    public void setUp(){
        stepsToReproduced = new StepsToReproduced();
        stepsToReproduced.initBrowser();
    }

    /**
     * Login user
     */
    @Test(description = "Login to onliner.by")
    public void loginOnliner() {
        stepsToReproduced.loginOnliner(USERNAME, PASSWORD);
        Assert.assertTrue(stepsToReproduced.isLoggedIn());
    }

    /**
     * Exit User
     */
    @Test(description = "LogOut to onliner.by")
    public void logOutOnliner(){
        stepsToReproduced.logoutOnliner(USERNAME, PASSWORD);
        Assert.assertTrue(stepsToReproduced.isLoggedOut());
    }

    /**
     * Product Search
     */
    @Test(description = "Search onliner.by")
    public void search(){
        stepsToReproduced.search(SEARCH_PRODUCT);
        Assert.assertTrue(stepsToReproduced.isSearched());
    }

    /**
     * Send a message to the user
     */
    @Test(description = "SendMessage onliner.by")
    public void sendMessage(){
        stepsToReproduced.sendMessage(NAME,USERNAME,PASSWORD,TEXT);
        Assert.assertTrue(stepsToReproduced.isSendMessage());
    }

    /**
     * Add this item from the trash
     */
    @Test(description = "EnterBasket onliner.by")
    public void enterBasket() throws InterruptedException {
        stepsToReproduced.enterBasket(USERNAME,PASSWORD);
        Assert.assertTrue(stepsToReproduced.isEnterBasket());
    }

    /**
     * Comparison of products in the catalog
     */
    @Test(description = "Compare onliner.by")
    public void compare() throws InterruptedException {
        stepsToReproduced.compare(USERNAME,PASSWORD,TEXT);
        Assert.assertTrue(stepsToReproduced.isCompare());
    }
}

