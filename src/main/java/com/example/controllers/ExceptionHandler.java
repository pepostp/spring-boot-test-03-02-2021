package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    // internal case
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> errorResponse(Exception ex) {

        Map<String, Object> rtn = new LinkedHashMap<>();

        rtn.put("status", "error");
        rtn.put("message", ex.getMessage());
        return rtn;
    }

    //custom case
    @org.springframework.web.bind.annotation.ExceptionHandler({CustomException.class})
    @ResponseBody
    public ResponseEntity<Map<String,Object>> handleCustomException(CustomException e) {

        Map<String,Object> errorInfo = new HashMap<>();

        errorInfo.put("status","error");
        errorInfo.put("message",e.getMessage());

        HttpStatus http_status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (400 == e.getCustomCode()){
            http_status = HttpStatus.BAD_REQUEST;
        }else if (404 == e.getCustomCode()){
            http_status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<Map<String,Object>>(errorInfo, http_status);
    }

}
