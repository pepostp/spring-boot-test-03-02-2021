package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    // internal case
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> errorResponse(Exception ex) {

        Map<String, Object> rtn = new LinkedHashMap<>();

        rtn.put("status", "error");
        rtn.put("message", ex.getMessage());
        return rtn;
    }

    //custom case
    @org.springframework.web.bind.annotation.ExceptionHandler({CustomException.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> handleCustomException(CustomException ex) {

        Map<String, Object> rtn = new LinkedHashMap<>();

        rtn.put("status", "error");
        rtn.put("message", ex.getCustomMessage());
        return rtn;
    }

}
