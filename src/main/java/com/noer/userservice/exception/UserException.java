package com.noer.userservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {
    private static final long serialVersionUID = 6L;
    private String message;
    public UserException( String message) {
        this.message = message;
    }
}
