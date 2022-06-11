package br.com.udemy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

    private static final long serialVersionUID = -8979961052781192454L;

    public UnsupportedMathOperationException(String message) {
        super(message);
    }
}
