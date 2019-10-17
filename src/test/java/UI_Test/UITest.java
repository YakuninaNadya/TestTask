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
    // тест ищет тендер по id и проверяем тот ли тендер был найден
    public void TenderIDSearchTest() {
        
        // запускаем браузер и переходим на сайт
        MainPage mainPage = new MainPage(driver);
        
        // кликаем по ссылке "процедуры"
        TendersPage tendersPage = mainPage.selectTendersTab();
        
        // проверяем, что мы действительно находимся в процедурах
        Assert.assertEquals(tendersPage.getTitle(), "ПРОЦЕДУРЫ");
        
        // в поиске вводим id тендера и нажимаем на кнопку "найти"
        tendersPage.enterTenderID("401567");
        tendersPage.clickSearchButton();
        
        // получаем количество найденных строк и сверяем его с заданным
        int rowCount = tendersPage.getNumberOfRows();
        Assert.assertEquals(rowCount, 1);
        
        // в полученной строке находим id тендера и сверяем его с заданным id
        String id = tendersPage.getID(1);
        Assert.assertEquals(id, "401567");


    }

}


