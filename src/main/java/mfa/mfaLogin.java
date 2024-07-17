package mfa;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mfaLogin {
    private static final String USER_SECRET_KEY = "***";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Open URL
            String url = "https://github.com/login";  // Replace with the actual URL
            driver.manage().window().maximize();
            driver.get(url);

            // Find username and password fields and fill them in
            String username = "***@nagarro.com";  // Replace with your username
            String password = "***";  // Replace with your password

            WebElement usernameField = driver.findElement(By.id("login_field"));  // Replace with the actual ID of the username field
            WebElement passwordField = driver.findElement(By.id("password"));  // Replace with the actual ID of the password field

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            WebElement signinButton = driver.findElement(By.xpath("//input[@type='submit']"));
            signinButton.click();

            WebElement toptField = driver.findElement(By.id("app_totp"));
            toptField.sendKeys(readOtp());


            // Add a delay to observe the result, if necessary
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
    static String readOtp(){
        Totp totp = new Totp(USER_SECRET_KEY); // 2FA secret key
        String twoFactorCode = totp.now(); // Generated 2FA code here
        return twoFactorCode;
    }
}
