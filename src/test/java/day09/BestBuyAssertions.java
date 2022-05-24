package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BestBuyAssertions {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("https://www.bestbuy.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "https://www.bestbuy.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
        String title = driver.getTitle();
        boolean isRest = title.contains("Rest");
       Assert.assertFalse(isRest);
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        boolean displayedLogo = logo.isDisplayed();
        Assert.assertTrue(displayedLogo);
        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));
        boolean displayedfrancais = francais.isDisplayed();
        Assert.assertTrue(displayedfrancais);


    }

}
