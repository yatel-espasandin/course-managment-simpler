package com.gestion.exception;

public class EmptyFieldException extends RuntimeException{
    public EmptyFieldException() {
        super ("No debe haber campos vacios, intente nuevamente.");
    }
}
