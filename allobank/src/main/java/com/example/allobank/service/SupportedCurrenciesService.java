package com.example.allobank.service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.allobank.service.FrankfuterService;

@Service
public class SupportedCurrenciesService {

    @Autowired
    private FrankfuterService frankfuterService;

    private RestTemplate restTemplate = new RestTemplate();

    public Map<String, String> GetResponse() {
        Map<String, String> result = this.restTemplate.getForObject(
          frankfuterService.GetCurrenciesUrl(),
          Map.class);
        return result;
    }

}
