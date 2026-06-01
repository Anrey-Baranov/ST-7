package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        if (chromeDriverPath == null) {
            chromeDriverPath = "A:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        
        WebDriver webDriver = new ChromeDriver();
        try {
            System.out.println("=== Задание №1: Генератор паролей ===");
            webDriver.get("https://www.calculator.net/password-generator.html");

            WebElement passwordElement = webDriver.findElement(By.id("generated-password"));
            String password = passwordElement.getAttribute("value");
            System.out.println("Сгенерированный пароль: " + password);
            System.out.println("Задание №1 выполнено.");

            Task2.getIpAddress(webDriver);

            Task3.getWeatherForecast(webDriver);
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}