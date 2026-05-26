package com.caso3.soporte.exception;

//Excepcion para cuando se incumple una regla
public class BusinessException extends RuntimeException{

    public BusinessException(String mensaje){
        super(mensaje);
    }
}
