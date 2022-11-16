package browsertestingkrupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTestHerokuapp {
    public static void main(String[] args) {
        //define url
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //define set containing key webdriver and value firefox driver
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        //declare an object
        WebDriver driver = new FirefoxDriver();
        //launch the page
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //implicit define time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("Title: "+driver.getTitle());
        //Print the current url
        System.out.println("URL: "+driver.getCurrentUrl());
        //Print the page source
        System.out.println("Page Source: "+driver.getPageSource());
        //locate the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        //Enter the username to username field
        usernameField.sendKeys("tomsmith");
        //locate the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        //Enter the password to password field
        passwordField.sendKeys("SuperSecretPassword!");
        //Close the browser
        driver.quit();
    }
}
