package UI.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Search extends AbstractPage{

    private static final String BASE_URL = "https://www.onliner.by";

    @FindBy(name = "query")
    private WebElement query;

    @FindBy(linkText = "Холодильники")
    private WebElement refreger;

    /**
     * Constructor
     */
    public Search(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    /**
     * Begin search
     */
    public void search(String searcWorld) {
        query.click();
        query.clear();
        query.sendKeys(searcWorld);
    }

    public boolean isSearch(){
        return  refreger.isDisplayed();
    }

}