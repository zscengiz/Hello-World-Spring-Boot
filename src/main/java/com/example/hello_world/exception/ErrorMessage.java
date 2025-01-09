package com.example.hello_world.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private MessageType messageType;
    private String ofStatic;

    public ErrorMessage(MessageType messageType) {
        this.messageType = messageType;
    }

    public String prepareErrorMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessage());
        if(this.ofStatic != null){
            stringBuilder.append(" : " + ofStatic);
        }
        return stringBuilder.toString();
    }
}
