import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import lvAcodemy.page_object.AddStudentPage;
import lvAcodemy.page_object.Notifications;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.LocalDriverManager;

import static java.time.Duration.ofSeconds;
import static utils.ConfigurationProperties.getConfiguration;

@Slf4j

public class StudentAppTest {

    Faker fakeData = new Faker();


    WebDriverWait wait = new WebDriverWait(driver, ofSeconds(getConfiguration().getLong("wait.time")));
    mainPage mainPage = new MainPage(driver);
    AddStudentPage addStudentPage = new AddStudentPage(driver);
    Notifications notifications = new Notifications(driver, wait);


    @Test
    public void createStudentTest() {

        LocalDriverManager.getInstance().manage().timeouts().implicitlyWait(ofSeconds(getConfiguration().getLong("wait.time")));

        logger.info("Will open now: " +getConfiguration().getString("app.url"));
        driver.get(getConfiguration().getString("app.url"));
        mainPage.openAddStudentPage();

        By studentButton = By.id("addStudentButton");
        WebElement addStudentButton = null;
        addStudentButton.click();
        WebElement nameInputField = driver.findElement(By.id("name"));
        nameInputField.sendKeys(fakeData.name().fullName());
        addStudentPage.setNameField(fakeData.name().fullName());

        addStudentPage.setGender("Female");

        WebElement emailInputField = driver.findElement(By.id("id=email"));
        emailInputField.sendKeys(fakeData.internet().emailAddress());
        addStudentPage.setEmailField(fakeData.internet().emailAddress());

        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[text()='MALE']")).click();

        WebElement element = driver.findElement(By.xpath("//span[text()='Submit']//parent::button"));
        WebElement submitButton = null;
        submitButton.click();

        notifications.getNotificationLocator();
        addStudentPage.submitStudent();
        Assertions.assertThat(notifications.getNotificationLocator().getText()).isEqualTo("Student successfully added!")

    }

        @AfterMethod
        public void tearDown() {
            LocalDriverManager.closeDriver();




        }

    private class MainPage {
        public MainPage(ChromeDriver driver) {
        }
    }
}

