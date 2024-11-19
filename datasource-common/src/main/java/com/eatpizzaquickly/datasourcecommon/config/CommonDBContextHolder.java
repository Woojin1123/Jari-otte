package com.eatpizzaquickly.datasourcecommon.config;

import com.eatpizzaquickly.datasourcecommon.enums.ServiceDatabase;
import org.springframework.util.Assert;

public class CommonDBContextHolder {

    private static ThreadLocal<ServiceDatabase> CONTEXT = new ThreadLocal<>();

    public static void set(ServiceDatabase database) {
        Assert.notNull(database, "clientDatabase cannot be null");
        CONTEXT.set(database);
    }

    public static ServiceDatabase getClientDatabase() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
