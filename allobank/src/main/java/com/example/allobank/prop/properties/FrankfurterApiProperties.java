package com.example.allobank.prop.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api.frankfurter")
public class FrankfurterApiProperties {

    private String protocol;
    private String domain;
    private String ver;
    private String baseCCY;
    private String latestPath;
    private String currenciesPath;

    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public String getDomain() { return domain;}
    public void setDomain(String domain) { this.domain = domain; }

    public String getVer() { return ver; }
    public void setVer(String ver) { this.ver = ver; }

    public String getBaseCCY() { return baseCCY; }
    public void setBaseCCY(String baseCCY) { this.baseCCY = baseCCY; }

    public String getLatestPath() { return latestPath; }
    public void setLatestPath(String latestPath) { this.latestPath = latestPath; }

    public String getCurrenciesPath() { return currenciesPath; }
    public void setCurrenciesPath(String currenciesPath) { this.currenciesPath = currenciesPath; }

}
