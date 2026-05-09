package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Task3 {
    public static void getWeatherForecast(WebDriver webDriver) throws Exception {
        System.out.println("\n=== Задание №3: Прогноз погоды в Нижнем Новгороде ===");
        
        String url = "https://api.open-meteo.com/v1/forecast?latitude=56&longitude=44&hourly=temperature_2m,rain&timezone=Europe%2FMoscow&forecast_days=1";
        webDriver.get(url);
        
        WebElement preElement = webDriver.findElement(By.tagName("pre"));
        String jsonString = preElement.getText();
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonString);
        JSONObject hourly = (JSONObject) json.get("hourly");
        
        JSONArray times = (JSONArray) hourly.get("time");
        JSONArray temperatures = (JSONArray) hourly.get("temperature_2m");
        JSONArray rains = (JSONArray) hourly.get("rain");
        
        System.out.println("\nПрогноз на сегодня:");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-2s | %-20s | %-12s | %-10s |\n", "№", "Дата/время", "Температура", "Осадки (мм)");
        System.out.println("-----------------------------------------------------------------");
        
        for (int i = 0; i < times.size(); i++) {
            String time = (String) times.get(i);
            double temp = (double) temperatures.get(i);
            double rain = (double) rains.get(i);
            
            System.out.printf("| %-2d | %-20s | %-12.1f | %-10.2f |\n", i + 1, time, temp, rain);
        }
        System.out.println("-----------------------------------------------------------------");
        
        //Сохраняем в файл
        java.io.File resultDir = new java.io.File("result");
        if (!resultDir.exists()) {
            resultDir.mkdir();
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("result/forecast.txt"))) {
            writer.println("Прогноз погоды в Нижнем Новгороде на сегодня:");
            writer.println("-----------------------------------------------------------------");
            writer.printf("| %-2s | %-20s | %-12s | %-10s |\n", "№", "Дата/время", "Температура", "Осадки (мм)");
            writer.println("-----------------------------------------------------------------");
            
            for (int i = 0; i < times.size(); i++) {
                String time = (String) times.get(i);
                double temp = (double) temperatures.get(i);
                double rain = (double) rains.get(i);
                
                writer.printf("| %-2d | %-20s | %-12.1f | %-10.2f |\n", i + 1, time, temp, rain);
            }
            writer.println("-----------------------------------------------------------------");
        }
        
        System.out.println("\nТаблица сохранена в файл: result/forecast.txt");
    }
}