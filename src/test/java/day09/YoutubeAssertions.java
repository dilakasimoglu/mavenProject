package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class YoutubeAssertions {

   public static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("(//a//tp-yt-paper-button[@id='button'])[6]")).click();
        String expectedTitle="YouTube"; // beklenen deger
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        System.out.println("Title:"+actualTitle );

        WebElement youtubelogo = driver.findElement(By.id("logo"));
        boolean displayed = youtubelogo.isDisplayed();
        Assert.assertTrue(displayed);

        WebElement boxElement = driver.findElement(By.id("search-icon-legacy"));
        boolean enabled = boxElement.isEnabled();
        Assert.assertTrue(enabled);

        String expectedWrongTitle= "youtube";
        Assert.assertNotEquals(expectedWrongTitle,actualTitle);

    }


}
