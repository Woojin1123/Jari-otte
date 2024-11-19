package com.eatpizzaquickly.datasourcecommon.enums;

public enum ServiceDatabase {
    CONCERT("concert"), USER("user"), RESERVATION("reservation"), COUPON("coupon");

    private final String database;

    ServiceDatabase(String database) {
        this.database = database;
    }
    public String getDatabase() {
        return database;
    }
}
