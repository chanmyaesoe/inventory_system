package net.javaguides.springboot.springboothelloworldtutorial.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj, Object...  pageInfo ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        if(ObjectUtils.isEmpty(pageInfo)){
            //do something here
        } else {
            map.put("pageInfo", pageInfo[0]);
        }
        return new ResponseEntity<Object>(map,status);
    }
}
