package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZeroApp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
        WebElement signinButton = driver.findElement(By.id("signin_button"));
        signinButton.click();
        WebElement userLogin = driver.findElement(By.id("user_login"));
        userLogin.sendKeys("username");
        WebElement userPassword = driver.findElement(By.name("user_password"));
        userPassword.sendKeys("password");
        WebElement signButton1 = driver.findElement(By.xpath("//input[@type='submit']"));
        signButton1.click();

    }
}
