package com.mercado.mercado.exception;

public class ExceptionMessage extends RuntimeException {

    public ExceptionMessage(String mensagemErro) {
        super(mensagemErro);
    }
}
