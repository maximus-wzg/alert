package com.ultrapower.alert.alert.core.gather.util;

import java.util.UUID;

public class UUIDGenerator {

    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
