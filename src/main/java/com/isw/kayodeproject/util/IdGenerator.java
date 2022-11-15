package com.isw.kayodeproject.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerator {

    public String createId() {
        //use this for user

        return UUID.randomUUID().toString();
    }
}
