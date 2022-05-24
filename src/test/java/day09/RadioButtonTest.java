package day09;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
         wait =new WebDriverWait(driver,20);


    }

    @Test
    public void test1(){
        driver.get("https://www.facebook.com/");
        WebElement cookieButton= driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']"));
        cookieButton.click();
        WebElement create_new_accountLink = driver.findElement(By.linkText("Create New Account"));
        create_new_accountLink.click();
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));
        boolean selectedFemale = female.isSelected();
        if (!selectedFemale){
            female.click();
        }


    }
}
