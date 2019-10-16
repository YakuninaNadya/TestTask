package UI_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UITest {

    private WebDriver driver;

    @BeforeTest
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/nadezhdayakunina/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://new.tender.pro/");
    }

    @Test
    public void TenderIDSearchTest() {
        MainPage mainPage = new MainPage(driver);
        TendersPage tendersPage = mainPage.selectTendersTab();
        Assert.assertEquals(tendersPage.getTitle(), "ПРОЦЕДУРЫ");
        tendersPage.enterTenderID("401567");
        tendersPage.clickSearchButton();
        int rowCount = tendersPage.getNumberOfRows();
        Assert.assertEquals(rowCount, 1);
        String id = tendersPage.getID(1);
        Assert.assertEquals(id, "401567");


    }

}


