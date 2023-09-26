package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;



    @Before
    public static void open_browser() {
        //System.setProperty("webdriver.chrome.driver", "https://www.google.com/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); // Delete cookies
        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        String URL="https://www.google.com/";
        driver.navigate().to(URL); // ==> Sign in page

        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,2000).perform();


    }
    @After
    public void quit_from_browser() {
        driver.quit();
    }


}
