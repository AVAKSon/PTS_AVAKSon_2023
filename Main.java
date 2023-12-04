package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AVAKSon\\Documents\\pts-2023-2024-master\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://ais2.ukf.sk/ais/start.do");
        try{
            Thread.sleep(1000);

            WebElement cookiesOkButton = driver.findElement(By.id("accept-cookies"));       //cookies
            cookiesOkButton.click();

            WebElement usernameBox = driver.findElement(By.id("login"));                    //login
            usernameBox.sendKeys("321819");
            WebElement passwordBox = driver.findElement(By.id("heslo"));
            passwordBox.sendKeys("9802169245");
            WebElement loginButton = driver.findElement(By.id("login-form-submit-btn"));
            loginButton.click();

            Thread.sleep(1000);
                                                                                            //opening schedule
            WebElement scheduleButton = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[3]/app-body/div[1]/div/app-rozvrh/div/div/button"));
            scheduleButton.click();

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  //taking a screenshot
            FileUtils.copyFile(screenshot, new File("schedule screenshot.png"));
            Thread.sleep(1000);
                                                                                            //logout
            WebElement dropDownButton = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]"));
            dropDownButton.click();
            WebElement logoutButton = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a"));
            logoutButton.click();

        } catch (InterruptedException e) {
        e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}