package com.example.hello_world.controller;

import com.example.hello_world.entity.RootEntity;

public class RestBaseController {
    public <T>RootEntity<T> ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T>RootEntity<T> error(String message) {
        return RootEntity.error(message);
    }
}
