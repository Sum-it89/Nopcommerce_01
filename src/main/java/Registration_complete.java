import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Registration_complete
{

    protected static WebDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");

        //clicks register button at the home page.......
        driver.findElement(By.linkText("Register")).click();
        //selects male radio button and clicks in the registration form.....
        driver.findElement(By.xpath("//input[@type= 'radio' and @id='gender-male']" )).click();
       //selects first name text box and inputs given name in the box.......
        driver.findElement(By.xpath("//input[@type=\"text\" and @id=\"FirstName\"]" )).sendKeys("Homer");
        //selects last name text box and inputs given last name in the box.......
        driver.findElement(By.xpath("//input[@type=\"text\" and @id=\"LastName\"]" )).sendKeys("Simpson");
        //selects email text box and inputs given email address in the box.......
        driver.findElement(By.xpath("//input[@type=\"email\" and @id=\"Email\"]")).sendKeys("simpsonhomer@outlook.co.uk");
        //selects check box button and unchecks the Newsletter button......
        driver.findElement(By.xpath("//input[@type=\"checkbox\" and @id=\"Newsletter\"]")).click();
        //selects Password text box and inputs given Password in the box.......
        driver.findElement(By.id("Password")).sendKeys("Homer1234");
        //selects Confirm password text box and inputs given Password in the box second time.......
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Homer1234");
        //selects REGISTER submit button and clicks the button.......
        driver.findElement(By.id("register-button")).click();






    }
}
