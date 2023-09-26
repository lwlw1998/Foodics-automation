package Pages;

import static StepDef.Hooks.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P01_googleSearch {
    public WebElement googleSearchInput(){
    WebElement searchinput=driver.findElement(By.cssSelector("Textarea[id=\"APjFqb\"]"));
    return searchinput;
    }
    public WebElement ValidateResultsAppearsOnUI(){
        WebElement results=driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        return results;
    }
    public List<WebElement> SearchResults(){
        List<WebElement> relatedResults=driver.findElements(By.cssSelector("a[class=\"k8XOCe R0xfCb VCOFK s8bAkb\"]"));
        return relatedResults;
    }

}
