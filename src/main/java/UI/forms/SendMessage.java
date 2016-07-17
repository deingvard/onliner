package UI.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessage extends AbstractPage{

    private static final String BASE_URL = "https://www.onliner.by";

    @FindBy(xpath = ".//*[@id='userbar']")
    private WebElement user_authentification_form;

    @FindBy(css = "input.auth-box__input")
    private WebElement auth_box;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement button;

    @FindBy(linkText = "Cообщения")
    private WebElement linkText;

    @FindBy(linkText = "Написать")
    private WebElement linkText1;

    @FindBy(id = "compose_uname")
    private WebElement uname;

    @FindBy(id = "compose_subject")
    private WebElement subject;

    @FindBy(id = "compose_text")
    private WebElement writeMessage;

    @FindBy(name = "post")
    private WebElement post;

    @FindBy(linkText = "Отправленные")
    private WebElement linkText2;

    @FindBy(id = "l_sentbox_tm")
    private WebElement sentbox;

    /**
     * Constructor
     */
    public SendMessage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(String URL) {
        driver.navigate().to(URL);
    }

    /**
     * Sends a message to another user
     */
    public void sendMessage(String name, String userName, String pass, String text) {
        user_authentification_form.click();
        auth_box.clear();
        auth_box.sendKeys(userName);
        password.click();
        password.clear();
        password.sendKeys(pass);
        button.click();
        linkText.click();
        linkText1.click();
        uname.clear();
        uname.sendKeys(name);
        subject.click();
        subject.clear();
        subject.sendKeys(text);
        writeMessage.click();
        writeMessage.clear();
        writeMessage.sendKeys(text);
        post.click();
        linkText2.click();
    }

    public boolean isSendMessage(){
        return sentbox.getText().contains("");
    }
}