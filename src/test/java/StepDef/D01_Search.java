package StepDef;

import Pages.P01_googleSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

import java.util.ArrayList;

import static StepDef.Hooks.driver;
public class D01_Search {

    P01_googleSearch search= new P01_googleSearch();
    SoftAssert soft = new SoftAssert();
    JavascriptExecutor js=(JavascriptExecutor)driver;
    ArrayList list=new ArrayList<>();





    @Given("User Entre a word {string}")
    public void user_entre_a_word(String word) {
        search.googleSearchInput().sendKeys(word+Keys.ENTER);

        //search.googleSearchInput().sendKeys(Keys.ENTER);
    }

    @And("Delete the word")
    public void delete_the_word() {
        search.googleSearchInput().clear();
    }

    @And("rewrite newWord {string}")
    public void rewrite_new_word(String string) {
        search.googleSearchInput().sendKeys(string+Keys.ENTER);

    }
    @And("Validate that number of results appears on UI")
    public void validate_that_number_of_results_appears_on_ui() throws InterruptedException {
        System.out.println(search.ValidateResultsAppearsOnUI().getText().toLowerCase());
        soft.assertTrue(search.ValidateResultsAppearsOnUI().getText().toLowerCase().contains("نتيجة"));
        soft.assertAll();

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);
    }
    @And("Validate search suggestion displayed")
    public void validate_search_suggestion_displayed() {
      for (WebElement element : search.SearchResults()){
          list.add((element.getText()));
          element.isDisplayed();
        }
      System.out.println(list);


    }





}
