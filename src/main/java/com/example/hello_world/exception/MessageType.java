package com.example.hello_world.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public enum MessageType {

    USER_NOT_FOUND("3001", "User Not Found", "The requested user could not be found.", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("3002", "User Already Exists", "This user already exists.", HttpStatus.CONFLICT),
    TOKEN_IS_EXPIRED("1005", "Token Is Expired", "This token is expired.", HttpStatus.UNAUTHORIZED),
    USERNAME_OR_PASSWORD_INVALID("1007","Usernanme Or Password Invalid", "This username or password is wrong", HttpStatus.BAD_REQUEST),
    CREATED("201", "Created", "The request was successful.", HttpStatus.CREATED),
    GENERAL_EXCEPTION("9999", "General Exception", "Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String title;
    @Getter
    private final String message;
    private final HttpStatus status;

    MessageType(String code, String title, String message, HttpStatus status) {
        this.code = code;
        this.title = title;
        this.message = message;
        this.status = status;
    }

}
