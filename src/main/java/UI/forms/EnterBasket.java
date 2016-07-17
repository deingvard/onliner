package UI.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterBasket extends AbstractPage {

    private static final String BASE_URL = "https://www.onliner.by";

   @FindBy(xpath = ".//*[@id='userbar']")
   private WebElement user_authentification_form;

    @FindBy(css = "input.auth-box__input")
    private WebElement auth_box;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement pass;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement button;

    @FindBy(css = "span.b-main-navigation__text")
    private WebElement navigation;

    @FindBy(xpath = "//div[@id='container']//li[2]/span")
    private WebElement container;

    @FindBy(linkText = "Ноутбуки")
    private WebElement linkText;

    @FindBy(css = "div.schema-product__title > a > span")
    private WebElement product;

    @FindBy(linkText = "В корзину")
    private WebElement linkText1;

    @FindBy(linkText = "1 товар")
    private WebElement linkText2;

    /**
     * Constructor
     */
    public EnterBasket(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    /**
     * Insert an item in the cart
     */
    public void enterBasket(String username, String password) throws InterruptedException {
        user_authentification_form.click();
        auth_box.clear();
        auth_box.sendKeys(username);
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        button.click();
        navigation.click();
        container.click();
        Thread.sleep(3000);
        linkText.click();
        product.click();
        Thread.sleep(6000);
        linkText1.click();
    }

    public boolean isEnterBasket(){
        return linkText.isDisplayed();
    }
}
