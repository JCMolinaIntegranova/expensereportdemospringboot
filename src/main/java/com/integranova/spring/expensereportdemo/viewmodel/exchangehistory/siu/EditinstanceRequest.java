package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Exchange History")
    @JsonProperty("p_thisexchangehistory_oid")
    private ExchangeHistoryOid exchangeHistoryeditinstancepthisExchangeHistory;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExchangeHistory exchangeHistoryeditinstancepthisExchangeHistoryInstance;

    @ApiModelProperty(name = "Old Value")
    @JsonProperty("p_oldvalue")
    private Double exchangeHistoryeditinstancepoldValue;

    @ApiModelProperty(name = "New Value")
    @JsonProperty("p_newvalue")
    private Double exchangeHistoryeditinstancepnewValue;

    public void checkArguments() throws NotNullArgumentException {
        checkExchangeHistoryeditinstancepthisExchangeHistory();
        checkExchangeHistoryeditinstancepoldValue();
        checkExchangeHistoryeditinstancepnewValue();
    }

    @JsonIgnore
    public ExchangeHistoryOid getExchangeHistoryeditinstancepthisExchangeHistory() {
        return this.exchangeHistoryeditinstancepthisExchangeHistory;
    }
    
    public void setExchangeHistoryeditinstancepthisExchangeHistory(ExchangeHistoryOid exchangeHistoryeditinstancepthisExchangeHistory) {
        this.exchangeHistoryeditinstancepthisExchangeHistory = exchangeHistoryeditinstancepthisExchangeHistory;
    }

    @JsonIgnore
    public ExchangeHistory getExchangeHistoryeditinstancepthisExchangeHistoryInstance() {
        return this.exchangeHistoryeditinstancepthisExchangeHistoryInstance;
    }
    
    public void setExchangeHistoryeditinstancepthisExchangeHistoryInstance(ExchangeHistory exchangeHistoryeditinstancepthisExchangeHistory) {
        this.exchangeHistoryeditinstancepthisExchangeHistoryInstance = exchangeHistoryeditinstancepthisExchangeHistory;
    }

    private void checkExchangeHistoryeditinstancepthisExchangeHistory() throws NotNullArgumentException {
        if(this.getExchangeHistoryeditinstancepthisExchangeHistoryInstance() == null || this.getExchangeHistoryeditinstancepthisExchangeHistoryInstance().isNull()) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPTHISEXCHANGEHISTORY, ExchangeHistoryConstants.SERV_ALIAS_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPTHISEXCHANGEHISTORY);
        }
    }

    @JsonIgnore
    public Double getExchangeHistoryeditinstancepoldValue() {
        return this.exchangeHistoryeditinstancepoldValue;
    }
    
    public void setExchangeHistoryeditinstancepoldValue(Double exchangeHistoryeditinstancepoldValue) {
        this.exchangeHistoryeditinstancepoldValue = exchangeHistoryeditinstancepoldValue;
    }

    private void checkExchangeHistoryeditinstancepoldValue() throws NotNullArgumentException {
        if(this.getExchangeHistoryeditinstancepoldValue() == null) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPOLDVALUE, ExchangeHistoryConstants.SERV_ALIAS_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPOLDVALUE);
        }
    }

    @JsonIgnore
    public Double getExchangeHistoryeditinstancepnewValue() {
        return this.exchangeHistoryeditinstancepnewValue;
    }
    
    public void setExchangeHistoryeditinstancepnewValue(Double exchangeHistoryeditinstancepnewValue) {
        this.exchangeHistoryeditinstancepnewValue = exchangeHistoryeditinstancepnewValue;
    }

    private void checkExchangeHistoryeditinstancepnewValue() throws NotNullArgumentException {
        if(this.getExchangeHistoryeditinstancepnewValue() == null) {
            throw new NotNullArgumentException(ExchangeHistoryConstants.SERV_ID_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ID, ExchangeHistoryConstants.ARG_ID_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPNEWVALUE, ExchangeHistoryConstants.SERV_ALIAS_EDITINSTANCE, ExchangeHistoryConstants.CLASS_ALIAS, ExchangeHistoryConstants.ARG_ALIAS_EDITINSTANCE_EXCHANGEHISTORYEDITINSTANCEPNEWVALUE);
        }
    }
}
