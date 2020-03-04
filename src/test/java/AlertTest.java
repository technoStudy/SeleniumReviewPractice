import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest {

    private WebDriver driver;

    @BeforeClass
    public void init(){
        System.setProperty("webdriver.chrome.driver", "D:\\TechnoStudy\\Selenium\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html" );
    }
    @Test
    public void simpleAlert(){
        String expectedText = "I am an alert box!";
        driver.findElement( By.cssSelector( "button[onclick=\"myAlertFunction()\"]" ) ).click();
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals( actualText, expectedText );

        driver.switchTo().alert().dismiss();
    }

    @Test
    public void confirmAlert(){
        String expectedText = "You pressed OK!";
        driver.findElement( By.cssSelector( "button[onclick=\"myConfirmFunction()\"]" ) ).click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement( By.id( "confirm-demo" ) ).getText();

        Assert.assertEquals( actualText, expectedText );
    }

    @Test
    public void confirmDismissAlert(){
        String expectedText = "You pressed Cancel!";
        driver.findElement( By.cssSelector( "button[onclick=\"myConfirmFunction()\"]" ) ).click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement( By.id( "confirm-demo" ) ).getText();

        Assert.assertEquals( actualText, expectedText );
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
