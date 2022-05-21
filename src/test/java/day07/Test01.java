package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Before
    public void setup(){
        driver.get("https://www.walmart.com/");
    }

    @Test
    public  void test1(){

        driver.navigate().refresh();
        String title = driver.getTitle();
        System.out.println("titel: "+title);
        if (title.contains("Save")){
            System.out.println("basligim save  kelimesi iceriyor");
        }else {
            System.out.println("save kelimsi icermiyor");
        }
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl: "+currentUrl);
        boolean iceriyormu = currentUrl.contains("walmart.com");
        //Assert.assertTrue(iceriyormu);
        if (iceriyormu){
            System.out.println("Url walmart.com iceriyor");
        }
        else {
            System.out.println("icermiyor");
        }
    }

    @Test
    public void test02(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Nutella");

    }
    @After
    public  void teardown() {
       // driver.close();
    }

}
