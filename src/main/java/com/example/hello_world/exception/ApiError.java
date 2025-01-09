package com.example.hello_world.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<E> {

    private Integer status;
    private Exception<E> exception;

}
