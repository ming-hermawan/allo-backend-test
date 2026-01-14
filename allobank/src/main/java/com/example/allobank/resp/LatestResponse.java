package com.example.allobank.resp;

import java.util.Map;

public class LatestResponse {
    private int amount;
    private String date;
    private String base;
    private Map<String, Double> rates;
    private Double USD_BuySpread_IDR;

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }

    public Map<String, Double> getRates() { return rates; }
    public void setRates(Map<String, Double> rates) { this.rates = rates; }

    public Double getUSD_BuySpread_IDR() { return USD_BuySpread_IDR; }
    public void setUSD_BuySpread_IDR(Double USD_BuySpread_IDR) {
        this.USD_BuySpread_IDR = USD_BuySpread_IDR;
    }

}
