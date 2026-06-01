package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");
        if (chromeDriverPath != null && !chromeDriverPath.isEmpty()) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        
        WebDriver webDriver = new ChromeDriver();
        try {
            System.out.println("=== Задание №1: Генератор паролей ===");
            webDriver.get("https://www.calculator.net/password-generator.html");
            
            System.out.println("Страница загружена. Пароль отображается в браузере.");
            System.out.println("Задание №1 выполнено - браузер открыт, Selenium работает.");
            
            // Задание №2
            Task2.getIpAddress(webDriver);
            
            // Задание №3
            Task3.getWeatherForecast(webDriver);
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}