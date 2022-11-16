package browsertestingkrupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTestHerokuapp {
    public static void main(String[] args) {
        //URL to test
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //set property of key and value to webdriver and chromedriver link
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //declare an object
        WebDriver driver = new ChromeDriver();
        //launch page
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //implicit define timeout
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
