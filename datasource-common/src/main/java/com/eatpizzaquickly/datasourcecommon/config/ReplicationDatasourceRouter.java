package com.eatpizzaquickly.datasourcecommon.config;

import com.eatpizzaquickly.datasourcecommon.enums.OperationType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class ReplicationDatasourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) ? OperationType.READ  : OperationType.WRITE;
    }
}
