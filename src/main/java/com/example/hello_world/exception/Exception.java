package com.example.hello_world.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exception<E> {

    private String path;
    private String hostname;
    private E message;
    private Date timeStamp;

}
