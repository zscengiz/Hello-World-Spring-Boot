package com.example.hello_world.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private Integer status;
    private T payload;
    private String errorMessage;
    private HttpStatus statusMessage;


    public static <T> RootEntity<T> ok(T payload) {

        RootEntity<T> rootEntity = new RootEntity<T>();

        rootEntity.setStatus(200);
        rootEntity.setPayload(payload);
        rootEntity.setErrorMessage(null);
        rootEntity.setStatusMessage(HttpStatus.OK);
        return rootEntity;
    }
    public static <T> RootEntity<T> error(String errorMessage) {

        RootEntity<T> rootEntity = new RootEntity<T>();

        rootEntity.setStatus(500);
        rootEntity.setPayload(null);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }

}
