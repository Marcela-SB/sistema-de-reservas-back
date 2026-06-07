package br.com.deart.sistemadereservasdeart.exceptions.base;

import org.springframework.http.HttpStatus;

public abstract class ConflictException extends HttpException {
    protected ConflictException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
