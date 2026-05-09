package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Task2 {
    public static void getIpAddress(WebDriver webDriver) throws Exception {
        System.out.println("\n=== Задание №2: Получение IP-адреса ===");
        webDriver.get("https://api.ipify.org/?format=json");
        
        WebElement preElement = webDriver.findElement(By.tagName("pre"));
        String jsonString = preElement.getText();
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);
        String ip = (String) json.get("ip");
        
        System.out.println("Ваш IP-адрес: " + ip);
    }
}