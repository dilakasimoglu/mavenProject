package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.sendKeys(Keys.ENTER);
        List<WebElement> liste = driver.findElements(By.xpath("//div[@class='a-section']"));
        int size = liste.size();
        System.out.println("size:"+ size);
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
        List<WebElement> basliklar = driver.findElements(By.tagName("h1"));
        for (WebElement baslik : basliklar) {
            System.out.println("baslik:"+ baslik.getText());
        }
    }
}

