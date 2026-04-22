package com.gold;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GoldRateInfo {

    private final Map<String, Double> goldRates;

    public GoldRateInfo(@Value("${gold.rate.18K}") double rate18K,
                        @Value("${gold.rate.22K}") double rate22K,
                        @Value("${gold.rate.24K}") double rate24K) {
        this.goldRates = new HashMap<>();
        this.goldRates.put("18K", rate18K);
        this.goldRates.put("22K", rate22K);
        this.goldRates.put("24K", rate24K);
    }

    public double calculateTotalPrice(String caratValue, double weightInGrams) {
        if (!goldRates.containsKey(caratValue)) {
            System.out.println("Invalid carat value: " + caratValue);
            return -1;
        }
        return goldRates.get(caratValue) * weightInGrams;
    }

    public void displayRates() {
        System.out.println("Available Gold Rates:");
        goldRates.forEach((carat, rate) ->
                System.out.printf("  %s: Rs.%.2f per gram%n", carat, rate));
    }

    public Map<String, Double> getGoldRates() {
        return goldRates;
    }
}
