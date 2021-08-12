package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeHistoryPutViewModel {

    @JsonProperty(value="oldValue")
    private Double exchangeHistoryoldValue;

    @JsonProperty(value="newValue")
    private Double exchangeHistorynewValue;

    public Double getExchangeHistoryoldValue() {
        return exchangeHistoryoldValue;
    }
    
    public void setExchangeHistoryoldValue(Double exchangeHistoryoldValue) {
        this.exchangeHistoryoldValue = exchangeHistoryoldValue;
    }

    public Double getExchangeHistorynewValue() {
        return exchangeHistorynewValue;
    }
    
    public void setExchangeHistorynewValue(Double exchangeHistorynewValue) {
        this.exchangeHistorynewValue = exchangeHistorynewValue;
    }
}
