package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BuildResponse {

    public ResponseEntity<?> successResponseBuilder(@RequestBody String msg, Integer code) {

        Map<String, Object> result = new LinkedHashMap<>();

        result.put("status", "success");
        result.put("message", msg);

        HttpStatus http_status = HttpStatus.OK;
        if (201 == code){
            http_status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(result, http_status);
    }

    public ResponseEntity<Map<String,Object>> errorResponseBuilder(CustomException e) {

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
