package com.wx.config.interceptor;

import com.wx.common.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice   // Spring 的异常处理的注解
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(BadRequestExceptionHandler.class);


    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> messages = new HashMap<>();
        BindingResult result = ex.getBindingResult();
        Result res = null;
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();
            res = Result.error(errors.get(0).getDefaultMessage());
//            for (ObjectError error : errors) {
//                FieldError fieldError = (FieldError) error;
//                messages.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
        }
        return ResponseEntity.ok().body(res);
    }
}

