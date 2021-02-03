package com.example.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

public class BuildResponse {
    public Map<String, Object> successResponseString(String msg) {

        Map<String, Object> rtn = new LinkedHashMap<>();

        rtn.put("status", "success");
        rtn.put("message", msg);
        return rtn;
    }

}
