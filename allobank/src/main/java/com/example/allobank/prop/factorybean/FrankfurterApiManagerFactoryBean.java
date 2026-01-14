package com.example.allobank.prop.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.allobank.prop.properties.FrankfurterApiProperties;
import com.example.allobank.prop.manager.FrankfurterApiManager;

@Component
public class FrankfurterApiManagerFactoryBean implements FactoryBean<FrankfurterApiManager> {

    private final FrankfurterApiProperties properties;

    @Autowired
    public FrankfurterApiManagerFactoryBean(FrankfurterApiProperties properties) {
        this.properties = properties;
    }

    @Override
    public FrankfurterApiManager getObject() throws Exception {
        return new FrankfurterApiManager(
          properties.getProtocol(),
          properties.getDomain(),
          properties.getVer(),
          properties.getBaseCCY(),
          properties.getLatestPath(),
          properties.getCurrenciesPath());
    }

    @Override
    public Class<?> getObjectType() {
        return FrankfurterApiManager.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
