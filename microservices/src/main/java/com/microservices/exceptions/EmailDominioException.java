package com.microservices.exceptions;

public class EmailDominioException extends RuntimeException{

    public EmailDominioException(String message) {
        super(message);
    }
}