package browsertestingkrupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTestingHerokuapp {
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        //declare scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Browser");
        //store user input into userBrowser
        String userBrowser = scanner.next();
        try {
            //if statement
            if(userBrowser.equalsIgnoreCase("chrome")){
                //set property of key and value to webdriver and chromedriver link
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                //declare an object
                driver = new ChromeDriver();
            } else if (userBrowser.equalsIgnoreCase("edge")) {
                //set property of key and value to webdriver and edgedriver link
                System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
                //declare an object
                driver = new EdgeDriver();
            } else if (userBrowser.equalsIgnoreCase("firefox")) {
                //set property of key and value to webdriver and geckodriver link
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                //declare an object
                driver = new FirefoxDriver();
            } else{
                System.out.println("Invalid Browser");
            }
            //launch page
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
            //driver.quit();
        }catch(Exception e){
            System.out.println("Invalid Browser Entry");
            System.exit(0);
        }
    }
}
