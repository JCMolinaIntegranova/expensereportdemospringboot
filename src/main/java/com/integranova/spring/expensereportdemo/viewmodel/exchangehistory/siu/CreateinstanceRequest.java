package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "ExpenseCurrency")
    @JsonProperty("p_agrexpensecurrency_oid")
    private ExpenseCurrencyOid exchangeHistorycreateinstancepagrExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency exchangeHistorycreateinstancepagrExpenseCurrencyInstance;

    @ApiModelProperty(name = "Old Value")
    @JsonProperty("p_atroldvalue")
    private Double exchangeHistorycreateinstancepatroldValue;

    @ApiModelProperty(name = "New Value")
    @JsonProperty("p_atrnewvalue")
    private Double exchangeHistorycreateinstancepatrnewValue;

    public void checkArguments() throws NotNullArgumentException {
        checkExchangeHistorycreateinstancepagrExpenseCurrency();
        checkExchangeHistorycreateinstancepatroldValue();
        checkExchangeHistorycreateinstancepatrnewValue();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExchangeHistorycreateinstancepagrExpenseCurrency() {
        return this.exchangeHistorycreateinstancepagrExpenseCurrency;
    }
    
    public void setExchangeHistorycreateinstancepagrExpenseCurrency(ExpenseCurrencyOid exchangeHistorycreateinstancepagrExpenseCurrency) {
        this.exchangeHistorycreateinstancepagrExpenseCurrency = exchangeHistorycreateinstancepagrExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExchangeHistorycreateinstancepagrExpenseCurrencyInstance() {
        return this.exchangeHistorycreateinstancepagrExpenseCurrencyInstance;
    }
    
    public void setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(ExpenseCurrency exchangeHistorycreateinstancepagrExpenseCurrency) {
        this.exchangeHistorycreateinstancepagrExpenseCurrencyInstance = exchangeHistorycreateinstancepagrExpenseCurrency;
    }

    private void checkExchangeHistorycreateinstancepagrExpenseCurrency() throws NotNullArgumentException {
        if(this.getExchangeHistorycreateinstancepagrExpenseCurrencyInstance() == null || this.getExchangeHistorycreateinstancepagrExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPAGREXPENSECURRENCY, ExchangeHistoryConstants.SERV_ALIAS_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPAGREXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public Double getExchangeHistorycreateinstancepatroldValue() {
        return this.exchangeHistorycreateinstancepatroldValue;
    }
    
    public void setExchangeHistorycreateinstancepatroldValue(Double exchangeHistorycreateinstancepatroldValue) {
        this.exchangeHistorycreateinstancepatroldValue = exchangeHistorycreateinstancepatroldValue;
    }

    private void checkExchangeHistorycreateinstancepatroldValue() throws NotNullArgumentException {
        if(this.getExchangeHistorycreateinstancepatroldValue() == null) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATROLDVALUE, ExchangeHistoryConstants.SERV_ALIAS_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATROLDVALUE);
        }
    }

    @JsonIgnore
    public Double getExchangeHistorycreateinstancepatrnewValue() {
        return this.exchangeHistorycreateinstancepatrnewValue;
    }
    
    public void setExchangeHistorycreateinstancepatrnewValue(Double exchangeHistorycreateinstancepatrnewValue) {
        this.exchangeHistorycreateinstancepatrnewValue = exchangeHistorycreateinstancepatrnewValue;
    }

    private void checkExchangeHistorycreateinstancepatrnewValue() throws NotNullArgumentException {
        if(this.getExchangeHistorycreateinstancepatrnewValue() == null) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATRNEWVALUE, ExchangeHistoryConstants.SERV_ALIAS_CREATEINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_CREATEINSTANCE_EXCHANGEHISTORYCREATEINSTANCEPATRNEWVALUE);
        }
    }
}
