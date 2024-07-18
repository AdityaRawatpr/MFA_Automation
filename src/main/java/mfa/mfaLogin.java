package mfa;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mfaLogin {
    private static final String USER_SECRET_KEY = "***";

    public static void main(String[] args) {
        readOtp()
        
    }
    static String readOtp(){
        Totp totp = new Totp(USER_SECRET_KEY); // 2FA secret key
        String twoFactorCode = totp.now(); // Generated 2FA code here
        return twoFactorCode;
    }
}
