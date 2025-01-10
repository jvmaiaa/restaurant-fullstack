package com.restaurant.fullstack.infra.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DadoInvalidoException extends DataIntegrityViolationException {

    public DadoInvalidoException(String message) {
        super(message);
    }
}
