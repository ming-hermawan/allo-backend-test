package com.example.allobank.service;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.allobank.service.FrankfuterService;
import com.example.allobank.resp.LatestResponse;

@Service
public class LatestIdrRatesService {

    /*
ASCII text = ming-hermawan
Decimal (bytes) = 109 105 110 103 45 104 101 114 109 97 119 97 110
Spread Factor = ( (109 + 105 + 110 + 103 + 45 + 104 + 101 + 114 + 109 + 97 + 119 + 97 + 110) % 1000) / 100000.0 = 0.00323
    */
    private final Double spreadFactor = 0.00323;

    @Autowired
    private FrankfuterService frankfuterService;

    private RestTemplate restTemplate = new RestTemplate();

    private double getUSDBuySpreadIDR(Double rateUSD) {
        return (1 / rateUSD) * (1 + this.spreadFactor);
    }

    public LatestResponse GetResponse() {
        LatestResponse out = this.restTemplate.getForObject(
          frankfuterService.GetLatestUrl(),
          LatestResponse.class);
        out.setUSD_BuySpread_IDR(
          this.getUSDBuySpreadIDR(out.getRates().get("USD"))
        );
        return out;
    }

}
