package UI_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public TendersPage selectTendersTab() {
        driver.findElement(By.linkText("Процедуры")).click();

        return new TendersPage(driver);
    }


}
