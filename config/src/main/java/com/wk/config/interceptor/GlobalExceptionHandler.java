package com.wk.config.interceptor;

import com.wk.common.exception.BusinessException;
import com.wk.common.exception.Errorcode;
import com.wk.common.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private <T> Result<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("---------> invalid request!", e);
        return Result.error(Errorcode.PARAMS_ERROR,e.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private <T> Result<T> businessExceptionHandler(BusinessException e) {
        logger.error("---------> invalid request!", e);
        return Result.error(e.getErrorcode(),e.getMessage());
    }

}
