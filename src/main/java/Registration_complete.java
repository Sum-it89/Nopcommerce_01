
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.text.SimpleDateFormat;
import java.time.Duration;


public class Registration_complete

{

    public static void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");

    }

    public static String timeStamp()
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    public static void quit(){

        driver.quit();
    }


    protected static WebDriver driver;
    public static void main(String[] args)
    {

        OpenBrowser();

        //waits until given time before clicking....
        waituntilclickable(10, By.linkText("Register"));

        //clicks register button at the home page.......
        clickonElements(By.linkText("Register"));

        //waits for the url going to be in the next page..........
        waitforUrltobe(10);

        //selects male radio button and clicks in the registration form.....
        clickonElements(By.xpath("//input[@type= 'radio' and @id='gender-male']" ));

       //selects first name text box and inputs given name in the box.......
        TypetextofElements(By.xpath("//input[@type=\"text\" and @id=\"FirstName\"]"),("Homer" ));

        //selects last name text box and inputs given last name in the box.......
        TypetextofElements(By.xpath("//input[@type=\"text\" and @id=\"LastName\"]"), ("Simpson"));

        SelecElement(By.name("DateOfBirthDay"),("8")); //selects the Birth day from the dropdown menu......

        SelectbyIndex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), (5)); //Selects the Birth Month from dropdown menu......

        SelectbyIndex(By.xpath("//select[@name=\"DateOfBirthYear\"]"), (10));// Selects the birth year from the dropdown menu....

        //selects email text box and inputs given email address in the box.......
        TypetextofElements(By.xpath("//input[@type=\"email\" and @id=\"Email\"]"), ("simpsonhomer"+timeStamp()+"@outlook.co.uk"));

        //selects check box button and unchecks the Newsletter button......
        clickonElements(By.xpath("//input[@type=\"checkbox\" and @id=\"Newsletter\"]"));

        //selects Password text box and inputs given Password in the box.......
        TypetextofElements(By.id("Password"), ("Homer1234"));

        //selects Confirm password text box and inputs given Password in the box second time.......
        TypetextofElements(By.id("ConfirmPassword"), ("Homer1234"));

        //wait until the element is visible....
        waituntilvisible(5, By.id("register-button"));

        //selects REGISTER submit button and clicks the button.......
        clickonElements(By.id("register-button"));

        //waits until the submit button is invisible.....
        waitforinvisible(5,(By.id("register-button")));


        System.out.println(getTextElement(By.className("result")));

        quit();


    }


    public static void clickonElements(By by){//click on elements........

        driver.findElement(by).click();
    }


    public static void TypetextofElements(By by, String text){  //type text......

        driver.findElement(by).sendKeys(text);
    }


    public static String getTextElement(By by){  //get text.................

       return driver.findElement(by).getText();
        //String registerSuccessText = driver.findElement((By.className("result"))).getText();
        //System.out.println(registerSuccessText);
    }

    public static void SelecElement(By by, String Text) {

        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByVisibleText(Text);
       // Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
       // selectDay.selectByVisibleText("8");
    }

    public static void  SelectbyIndex(By by, int index){

        Select selectMonth = new Select(driver.findElement(by));
        selectMonth.selectByIndex(index);
//        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
//        selectMonth.selectByIndex(5);
//        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
//        selectYear.selectByIndex(10);
    }


    public static void waituntilclickable(int sec, By by){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(by));
//      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
    }

    public static void waituntilvisible(int sec, By by){

        WebDriverWait visible = new WebDriverWait(driver, Duration.ofSeconds(sec));
        visible.until(ExpectedConditions.visibilityOfElementLocated(by));
//      WebDriverWait visible = new WebDriverWait(driver, Duration.ofSeconds(20));
//      visible.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-button")));
    }


    public static String waitforUrltobe(int sec){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(sec));
        String url =  driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(url));
        return url;
    }


    public static void waitforinvisible(int sec, By by){

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(by));
//      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//      wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("register-button")));
    }















}
