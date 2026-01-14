package com.example.allobank.service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.allobank.service.FrankfuterService;
import com.example.allobank.resp.HistoricalDataResponse1;
import com.example.allobank.resp.HistoricalDataResponse2;

@Service
public class HistoricalDataService {

    @Autowired
    private FrankfuterService frankfuterService;

    private RestTemplate restTemplate = new RestTemplate();

    public HistoricalDataResponse1 GetResponse(String dateFrom,
                                               String from,
                                               String to) {
        return this.restTemplate.getForObject(
          frankfuterService.GetHistoricalDataUrl(
            dateFrom,
            from,
            to),
          HistoricalDataResponse1.class);
    }

    public HistoricalDataResponse2 GetResponse(String dateFrom,
                                               String dateTo,
                                               String from,
                                               String to) {
        return this.restTemplate.getForObject(
          frankfuterService.GetHistoricalDataUrl(
            dateFrom,
            dateTo,
            from,
            to),
          HistoricalDataResponse2.class);
    }

}
