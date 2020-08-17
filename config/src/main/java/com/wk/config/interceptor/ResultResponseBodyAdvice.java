package com.wk.config.interceptor;

import com.wk.bean.SysLog;
import com.wk.common.util.LoggerUtil;
import com.wk.common.vo.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Result> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getParameterType()==Result.class;
    }

    @Override
    public Result beforeBodyWrite(Result result, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        SysLog log= LoggerUtil.getRequestLog();
        if(log!=null){
            log.setReturnData(result.toString());
            LoggerUtil.setRequestLog(log);
        }
        return result;
    }
}
