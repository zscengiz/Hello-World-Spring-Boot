package com.example.hello_world.exception;

import com.example.hello_world.exception.ErrorMessage;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private MessageType messageType;

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
        this.messageType = errorMessage.getMessageType();
    }

}
