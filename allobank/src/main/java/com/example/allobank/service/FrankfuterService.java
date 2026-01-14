package com.example.allobank.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.allobank.prop.manager.FrankfurterApiManager;

@Service
public class FrankfuterService {

    private final FrankfurterApiManager manager;

    private String addParamsToHistoricalDataUrl(String url,
                                                String from,
                                                String to) {
        String out;
        if( (from != null) && (to != null) ) {
            out = String.format("%s?base=%s&symbols=%s", url, from, to);
        } else if (from != null) {
            out = String.format("%s?base=%s", url, from);
        } else if (to != null) {
            out = String.format("%s?symbols=%s", url, to);
        } else {
            out = url;
        }
        return out;
    }

    @Autowired
    public FrankfuterService(FrankfurterApiManager manager) {
        this.manager = manager;
    }

    @PostConstruct
    public void init() {
        System.out.println(
          String.format(
            "FrankfurterApiManager initialized status: %b",
            this.manager.IsInitialized())
        );
    }

    public String GetBaseCCY() {
        return this.manager.GetBaseCCY();
    }

    public String GetLatestUrl(String baseCCY) {
        return String.format(
          "%s/%s?base=%s",
          this.manager.GetBaseURL(),
          this.manager.GetLatestPath(),
          baseCCY);
    }

    public String GetLatestUrl() {
        return this.GetLatestUrl(this.manager.GetBaseCCY());
    }

    public String GetCurrenciesUrl() {
        return String.format(
          "%s/%s",
          this.manager.GetBaseURL(),
          this.manager.GetCurrenciesPath());
    }

    public String GetHistoricalDataUrl(String dateFrom,
                                       String from,
                                       String to) {
        String out = String.format(
          "%s/%s",
          this.manager.GetBaseURL(),
          dateFrom);
        return addParamsToHistoricalDataUrl(out, from, to);
    }

    public String GetHistoricalDataUrl(String dateFrom,
                                       String dateTo,
                                       String from,
                                       String to) {
        String out = String.format(
          "%s/%s..%s",
          this.manager.GetBaseURL(),
          dateFrom,
          dateTo);
        return addParamsToHistoricalDataUrl(out, from, to);
    }

}
