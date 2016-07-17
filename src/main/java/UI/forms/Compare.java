package UI.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compare extends AbstractPage {

    private static final String BASE_URL = "https://www.onliner.by";

    @FindBy(className = "project-navigation__text")
    private WebElement container;

   @FindBy(xpath = "//*[@id='schema-products']/div[1]//span")
    private WebElement firstItem;

    @FindBy(xpath = "//*[@id='schema-products']/div[2]//span")
    private WebElement secondItem;

    @FindBy(linkText = "2 товара в сравнении")
    private WebElement linkToCompare;

   @FindBy(xpath = ".//*[@id='container']//div[1]")
    private WebElement title;

    /**
     * Constructor
     */
    public Compare(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    /**
     * Compare products
     */
    public void compare(String username,String password,String text) throws InterruptedException {
        container.click();
        firstItem.click();
        secondItem.click();
        linkToCompare.click();
    }

    /**
     * Compare products on line
     */
    public boolean isCompare(){
        return title.getText().contains("Сравнение товаров");
    }
}
