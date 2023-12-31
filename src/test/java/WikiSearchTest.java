import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikiSearchTest {
    public static void main(String[] args){

        //Set from the path to the Chrome Browser
        System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\SELENIUM_SUITES\\chromedriver-win32\\chromedriver.exe");

        //Open the Chrome Driver
        WebDriver driver = new ChromeDriver();

        //Navigate the URL home page
        driver.get("https://qawikisearch.ccbp.tech/");

        //Find and Enter the Search box input field Element
        WebElement searchInputEl = driver.findElement(By.xpath("//input[@id = 'searchInput']"));
        searchInputEl.sendKeys("HTML");

        //Find And Click the Search input button
        WebElement searchButton = driver.findElement(By.xpath("//button[@class = 'search-button']"));
        searchButton.click();

        //Wait until elements are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'result-item']")));

        //Find all the search results input Elements
        List<WebElement> searchResultsEl = driver.findElements(By.xpath("//div[@class = 'result-item']"));

        if(searchResultsEl.size()>0){
            System.out.println(searchResultsEl.size() + " Results Found");
        }

        //Quit the Web Driver Instance
        driver.quit();



    }
}
