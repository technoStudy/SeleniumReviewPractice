import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TextPresentTest {
    private WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html" );
    }

    @Test
    public void test(){
        long before = System.currentTimeMillis();
        driver.findElement( By.id( "title" ) ).sendKeys( "something" );
        driver.findElement( By.id( "description" ) ).sendKeys( "something" );
        driver.findElement( By.id( "btn-submit" ) ).click();

        WebDriverWait wait = new WebDriverWait( driver, 5);
        By id = By.id( "submit-control" );
        String text = "Form submited Successfully!";
        wait.until( ExpectedConditions.textToBePresentInElementLocated( id, text ));
        long after = System.currentTimeMillis();
        System.out.println((after - before) + " time passed" );
    }
}
