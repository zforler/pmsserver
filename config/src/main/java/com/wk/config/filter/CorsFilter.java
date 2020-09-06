package com.wk.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class CorsFilter implements Filter {

    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        System.out.println(request.getMethod());
        if("OPTION".equals(request.getMethod())){
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
//            response.setHeader("Access-Control-Allow-Headers",
//                    "Content-Type, x-requested-with, X-Custom-Header, Authorization");
            response.setHeader("Access-Control-Allow-Headers",
                    "*");
            return;
        }else{
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
//            response.setHeader("Access-Control-Allow-Headers",
//                    "Content-Type, x-requested-with, X-Custom-Header, Authorization");
            response.setHeader("Access-Control-Allow-Headers",
                    "*");
            chain.doFilter(req, res);
        }

    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
