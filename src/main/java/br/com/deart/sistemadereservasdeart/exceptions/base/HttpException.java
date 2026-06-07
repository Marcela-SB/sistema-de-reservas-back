package br.com.deart.sistemadereservasdeart.exceptions.base;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Classe base para todas as exceções de negócio que possuem um status HTTP associado.
 */
@Getter
public abstract class HttpException extends RuntimeException {
    
    private final HttpStatus status;

    protected HttpException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}