import lvAcodemy.page_object.SoucePages.InventoryPage;
import lvAcodemy.page_object.SoucePages.LoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ConfigurationProperties;
import utils.LocalDriverManager;

import java.time.Duration;

public class SouceDemoTest {

    WebDriver driver = LocalDriverManager.getInstance();
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @Test(description = "Test successful login")
    public void testLogin() {
        driver.get(ConfigurationProperties.getConfiguration().getString("sauce.demo.url"));
        loginPage.authorize("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfAllElements(inventoryPage.getInventoryItems()));
        inventoryPage.getInventoryItems();
        Assertions.assertThat(inventoryPage.getInventoryItems()).hasSize(6);
    }

    @AfterMethod
    public void after(){
        LocalDriverManager.closeDriver();
    }
}
