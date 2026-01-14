package com.example.allobank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.allobank.MainController;
import com.example.allobank.service.LatestIdrRatesService;
import com.example.allobank.service.HistoricalDataService;
import com.example.allobank.service.SupportedCurrenciesService;


@WebMvcTest(MainController.class)
class AllobankApplicationTests {

    @MockitoBean
    private LatestIdrRatesService latestIdrRatesService;

    @MockitoBean
    private HistoricalDataService historicalDataService;

    @MockitoBean
    private SupportedCurrenciesService supportedCurrenciesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void latestIdrRatesTest() throws Exception {
        mockMvc.perform(get("/api/finance/data/latest_idr_rates"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    void historicalDataTest() throws Exception {
        mockMvc.perform(get("/api/finance/data/01-01-2026"))
        .andExpect(status().isBadRequest())
        .andDo(print());
        mockMvc.perform(get("/api/finance/data/2026-01-01"))
        .andExpect(status().isOk())
        .andDo(print());
        mockMvc.perform(get("/api/finance/data/2026-01-01..2026-01-02"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    void supportedCurrenciesServiceTest() throws Exception {
        mockMvc.perform(get("/api/finance/data/supported_currencies"))
        .andExpect(status().isOk())
        .andDo(print());
    }

}
