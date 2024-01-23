package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    void testRunHomeAndSearch(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        WebElement selenium = driver.findElement(By.partialLinkText("https://www.selenium.dev"));
        boolean enabled = selenium.isEnabled();
        assertTrue(enabled);
    }
    @Test
    void findSeleniumTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        List<WebElement> searchUrls = driver.findElements(By.cssSelector("div"));

        boolean isFound = false;
        for (WebElement elem : searchUrls) {
            if (elem.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }

        assertTrue(isFound);
        driver.quit();
    }
}
