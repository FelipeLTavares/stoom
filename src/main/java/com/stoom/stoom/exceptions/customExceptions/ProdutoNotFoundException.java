package com.stoom.stoom.exceptions.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException () {
        super("Categoria irregular");
    }
}
