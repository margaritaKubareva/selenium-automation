package lvAcodemy.page_object.SoucePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.LocalDriverManager;

public class LoginPage {

    private WebDriver driver = LocalDriverManager.getInstance();
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, xpath = "//input[@data-test='username']")
    WebElement usernamefield;

    @FindBy(name = "login-button")
    WebElement loginButton;

    @FindBy(id = "password")
    WebElement passwordField;

    public void authorize(String username, String password){
        usernamefield.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }
}
