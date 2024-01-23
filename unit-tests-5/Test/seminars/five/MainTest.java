package seminars.five;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    public void testAuthorization() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000); // Let the user actually see something!
        WebElement loginBox = driver.findElement(By.name("user-name"));
        WebElement passwordBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.submit();
        Thread.sleep(2000); // Let the user actually see something!
        WebElement productsLabel = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
// WebElement productsLabel = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        assertEquals("Products", productsLabel.getText());
        driver.quit();
    }
    //5.1.

    //5.2.

    //5.3.
}