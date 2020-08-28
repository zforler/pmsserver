package com.wk.config.interceptor;

import com.wk.bean.UserInfo;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.exception.Errorcode;
import com.wk.common.vo.Result;
import com.wk.config.annotation.IgnoreAuth;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }
       if("/error".equalsIgnoreCase(request.getServletPath())) {
            return true;
       }
        //从header中获取token
        String token = request.getHeader("x-token");
        //token为空
        if (StringUtils.isEmpty(token)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(Result.error(Errorcode.TOKEN_ERROR,"请先登录").toString());
            return false;
        }
        UserInfo user = LocalMemCache.getUserByToken(token);
        if(user == null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(Result.error(Errorcode.TOKEN_ERROR,"请重新登录").toString());
            return false;
        }

        return true;
    }
}
