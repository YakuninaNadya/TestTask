package UI_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TendersPage extends MainPage {

    public TendersPage(WebDriver driver) {
        super(driver);

    }

    public void enterTenderID(String id) {

        driver.findElement(By.cssSelector("input[type='search']")).sendKeys(id);
    }

    public void clickSearchButton() {

        driver.findElement(By.xpath("//span[contains(@class, 'icon search')]")).click();

    }

    public String getTitle() {

        return driver.findElement(By.xpath("//span[contains(@class, 'item')] [contains(text(), 'Процедуры')]"))
                .getText();

    }


    public int getNumberOfRows() {

        return driver.findElements(By.xpath("//div[contains(@class, 'iac--search__result')]")).size();

    }

    public String getID(int row) {

        return driver.findElement(By.cssSelector("div.type span:nth-child(2)")).getText();

    }


}
