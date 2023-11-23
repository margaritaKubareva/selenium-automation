package lvAcodemy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddStudentPage {

    ChromeDriver driver;

    public AddStudentPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");

    public void setNameField(String input) {
        driver.findElement(nameField).sendKeys(input);
     driver.findElement(emailField).sendKeys(input);
    }

    public void setEmailField(String s) {

        driver.findElement(By.id("gender")).click();
        driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[text()='MALE']")).click();

        String genderValue = null;
        String genderValue1 = genderValue;
        {
            driver.findElement(By.id("gender")).click();
            driver.findElement(
                    By.xpath(String.format("//div[@class='rc-virtual-list-holder-inner']//div[text()='%s']", genderValue.toUpperCase()))).click();
        }
       

    }

    public void submitStudent() {
    }

    public void setGender(String female) {
    }
}
