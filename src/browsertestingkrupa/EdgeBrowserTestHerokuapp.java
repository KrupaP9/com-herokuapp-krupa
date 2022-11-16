package browsertestingkrupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTestHerokuapp {
    public static void main(String[] args) {
        //define Url to test
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //set property of key and value to webdriver and chromedriver link
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        //declare an object
        WebDriver driver = new EdgeDriver();
        //launch the page
        driver.get(baseUrl);
        //maximize the window
        driver.manage().window().maximize();
        //implicit wait time definition
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
