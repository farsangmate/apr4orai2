import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IndexPage extends Pages {
    private final String URL = "https://automationexercise.com/products";

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.navigate().to(URL);
    }

    private final By SEARCH_BOX = By.xpath("//input[@id='search_product']");

    public void searchItem(String itemName) {
        driver.findElement(SEARCH_BOX).sendKeys(itemName);
    }

    private final By SEARCH_BUTTON = By.xpath("//button[@id='submit_search']");

    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();

    }

    private final By ITEM = By.xpath("//div[@class='features_items']/div[@class='col-sm-4']/div/div/div/p");

    public String[] listItems() {
        List<WebElement> items = driver.findElements(ITEM);

        String[] resultArray = new String[items.size()];
        int count = 0;
        for (WebElement item : items) {
            resultArray[count++] = item.getText();
        }
        return resultArray;
    }
}
