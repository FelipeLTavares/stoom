package com.stoom.stoom.exceptions.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarcaNotFoundException extends RuntimeException {
    public MarcaNotFoundException () {
        super("Marca não encontrada");
    }
}