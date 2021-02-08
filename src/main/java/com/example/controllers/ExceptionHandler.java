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
    @ResponseBody
    public ResponseEntity<Map<String,Object>> handleCustomException(CustomException e) {

        Map<String,Object> errorInfo = new HashMap<>();
        
        errorInfo.put("message",e.getMessage());
        errorInfo.put("status",e.getCustomStatus());

        HttpStatus http_status = HttpStatus.OK;
        
        if ("error" == e.getCustomStatus()){
            if (400 == e.getCustomCode()){
                http_status = HttpStatus.BAD_REQUEST;
            }else if (404 == e.getCustomCode()){
                http_status = HttpStatus.NOT_FOUND;
            }else if (500 == e.getCustomCode()){
                http_status = HttpStatus.INTERNAL_SERVER_ERROR;
            }

        }else if("success" == e.getCustomStatus()){
            if (201 == e.getCustomCode()){
                http_status = HttpStatus.CREATED;
            }
        }
        return new ResponseEntity<Map<String,Object>>(errorInfo, http_status);
    }

}
