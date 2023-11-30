package lvAcodemy.page_object.SoucePages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LocalDriverManager;

import java.util.List;

public class InventoryPage {

    private final WebDriver driver = LocalDriverManager.getInstance();

    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "inventory_list")
    List<WebElement> inventory;

    @Getter
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;
}
