package com.example.controllers;

public class CustomException extends RuntimeException {

    private String customMessage;
    private Integer customCode;
    private String customStatus;

    public CustomException(){
        super();
    }

    public CustomException(String customMessage, Integer customCode){
        super(new Exception(customMessage));
        this.customMessage = customMessage;
        this.customCode = customCode;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public Integer getCustomCode() {
        return customCode;
    }

}
