package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedHashMap;
import java.util.Map;

public class BuildResponse {

    public ResponseEntity<?> successResponseString(@RequestBody String msg, Integer code) {

        Map<String, Object> result = new LinkedHashMap<>();

        result.put("status", "success");
        result.put("message", msg);

        HttpStatus http_status = HttpStatus.OK;
        if (201 == code){
            http_status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(result, http_status);
    }

}
