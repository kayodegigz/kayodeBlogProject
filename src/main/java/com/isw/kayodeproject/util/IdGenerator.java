package com.isw.kayodeproject.util;

import java.util.UUID;

public class IdGenerator {

    public String createId() {
        //use this for user

        return UUID.randomUUID().toString();
    }
}
