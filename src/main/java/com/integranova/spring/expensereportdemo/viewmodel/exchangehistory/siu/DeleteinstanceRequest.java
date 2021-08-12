package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Exchange History")
    @JsonProperty("p_thisexchangehistory_oid")
    private ExchangeHistoryOid exchangeHistorydeleteinstancepthisExchangeHistory;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExchangeHistory exchangeHistorydeleteinstancepthisExchangeHistoryInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExchangeHistorydeleteinstancepthisExchangeHistory();
    }

    @JsonIgnore
    public ExchangeHistoryOid getExchangeHistorydeleteinstancepthisExchangeHistory() {
        return this.exchangeHistorydeleteinstancepthisExchangeHistory;
    }
    
    public void setExchangeHistorydeleteinstancepthisExchangeHistory(ExchangeHistoryOid exchangeHistorydeleteinstancepthisExchangeHistory) {
        this.exchangeHistorydeleteinstancepthisExchangeHistory = exchangeHistorydeleteinstancepthisExchangeHistory;
    }

    @JsonIgnore
    public ExchangeHistory getExchangeHistorydeleteinstancepthisExchangeHistoryInstance() {
        return this.exchangeHistorydeleteinstancepthisExchangeHistoryInstance;
    }
    
    public void setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(ExchangeHistory exchangeHistorydeleteinstancepthisExchangeHistory) {
        this.exchangeHistorydeleteinstancepthisExchangeHistoryInstance = exchangeHistorydeleteinstancepthisExchangeHistory;
    }

    private void checkExchangeHistorydeleteinstancepthisExchangeHistory() throws NotNullArgumentException {
        if(this.getExchangeHistorydeleteinstancepthisExchangeHistoryInstance() == null || this.getExchangeHistorydeleteinstancepthisExchangeHistoryInstance().isNull()) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_DELETEINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_DELETEINSTANCE_EXCHANGEHISTORYDELETEINSTANCEPTHISEXCHANGEHISTORY, ExchangeHistoryConstants.SERV_ALIAS_DELETEINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_DELETEINSTANCE_EXCHANGEHISTORYDELETEINSTANCEPTHISEXCHANGEHISTORY);
        }
    }
}
