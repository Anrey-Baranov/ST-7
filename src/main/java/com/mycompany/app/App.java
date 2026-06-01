package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        WebDriver webDriver = new ChromeDriver();
        try {
            System.out.println("=== Задание №1: Генератор паролей ===");
            webDriver.get("https://www.calculator.net/password-generator.html");
            
            WebElement passwordElement = webDriver.findElement(By.id("generated-password"));
            String password = passwordElement.getAttribute("value");
            System.out.println("Сгенерированный пароль: " + password);
            
            Task2.getIpAddress(webDriver);
            Task3.getWeatherForecast(webDriver);
            
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        } finally {
            webDriver.quit();
        }
    }
}