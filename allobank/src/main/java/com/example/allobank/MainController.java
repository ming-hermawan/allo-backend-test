package com.example.allobank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.allobank.service.LatestIdrRatesService;
import com.example.allobank.service.HistoricalDataService;
import com.example.allobank.service.SupportedCurrenciesService;

@RestController
public class MainController {

    final String regexHistoricalData1 = "^(\\d\\d\\d\\d\\x2D\\d\\d-\\d\\d)$";
    final String regexHistoricalData2 = "^(\\d\\d\\d\\d\\x2D\\d\\d-\\d\\d)\\x2E\\x2E(\\d\\d\\d\\d\\x2D\\d\\d-\\d\\d)$";

    private LatestIdrRatesService latestIdrRatesService;
    private HistoricalDataService historicalDataService;
    private SupportedCurrenciesService supportedCurrenciesService;

    public MainController(LatestIdrRatesService latestIdrRatesService,
                          HistoricalDataService historicalDataService,
                          SupportedCurrenciesService supportedCurrenciesService) {
        this.latestIdrRatesService = latestIdrRatesService;
        this.historicalDataService = historicalDataService;
        this.supportedCurrenciesService = supportedCurrenciesService;
    }

    @GetMapping("/api/finance/data/{resourceType}")
    public ResponseEntity<?> getObj(@PathVariable String resourceType,
                             @RequestParam(
                               value = "from",
                               required = false,
                               defaultValue = "IDR") String from,
                             @RequestParam(
                               value = "to",
                               required = false) String to) {
        if (resourceType.equals("latest_idr_rates")) {
            return ResponseEntity.ok(
              latestIdrRatesService.GetResponse()
            );
        } else if (resourceType.equals("supported_currencies")) {
            return ResponseEntity.ok(
              supportedCurrenciesService.GetResponse()
            );
        } else {
            // Pattern 1
            Pattern pattern1 = Pattern.compile(regexHistoricalData1);
            Matcher matcher1 = pattern1.matcher(resourceType);
            boolean match1Found = matcher1.find();
            if(match1Found) {
                String dateFrom = matcher1.group(1);
                return ResponseEntity.ok(
                  historicalDataService.GetResponse(dateFrom, from, to)
                );
            }
            // Pattern 2
            Pattern pattern2 = Pattern.compile(regexHistoricalData2);
            Matcher matcher2 = pattern2.matcher(resourceType);
            boolean match2Found = matcher2.find();
            if(match2Found) {
                String dateFrom = matcher2.group(1);
                String dateTo = matcher2.group(2);
                return ResponseEntity.ok(
                  historicalDataService.GetResponse(dateFrom, dateTo, from, to)
                );
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

}
