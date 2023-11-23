package lvAcodemy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LocalDriverManager;

public class mainPage {

    ChromeDriver driver = LocalDriverManager.getInstance();


    private final By addStudentButton = By.id("addStudentButton");

    public void openAddStudentForm() {
        driver.findElement(addStudentButton).click();
    }
    }
