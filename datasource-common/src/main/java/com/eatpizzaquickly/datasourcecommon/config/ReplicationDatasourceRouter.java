package com.eatpizzaquickly.datasourcecommon.config;

import com.eatpizzaquickly.datasourcecommon.enums.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import static org.springframework.transaction.support.TransactionSynchronizationManager.isCurrentTransactionReadOnly;

@Slf4j
public class ReplicationDatasourceRouter extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = isCurrentTransactionReadOnly() ? OperationType.READ.name() :  OperationType.WRITE.name();
        log.info(">>>>>> current data source : {}", dataSourceName);
        return dataSourceName;
    }
}
