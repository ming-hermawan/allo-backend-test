package com.example.allobank.prop.manager;

public class FrankfurterApiManager {

    private boolean initialized = false;
    private String protocol;
    private String domain;
    private String ver;
    private String baseCCY;
    private String baseURL;
    private String latestPath;
    private String currenciesPath;

    private String baseUrlFormat(String protocol,
                                 String domain,
                                 String ver) {
        return String.format("%s://%s/%s", protocol, domain, ver);
    }

    public FrankfurterApiManager(String protocol,
                                 String domain,
                                 String ver,
                                 String baseCCY,
                                 String latestPath,
                                 String currenciesPath) {
        this.protocol = protocol;
        this.domain = domain;
        this.ver = ver;
        this.baseURL = this.baseUrlFormat(
          this.protocol,
          this.domain,
          this.ver);
        this.baseCCY = baseCCY;
        this.latestPath = latestPath;
        this.currenciesPath = currenciesPath;
        this.initialized = true;
    }

    public boolean IsInitialized() {
        return this.initialized;
    }

    public String GetBaseCCY() {
        return this.baseCCY;
    }

    public String GetBaseURL() {
        return this.baseURL;
    }

    public String GetLatestPath() {
        return this.latestPath;
    }

    public String GetCurrenciesPath() {
        return this.currenciesPath;
    }

}
