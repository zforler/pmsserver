package com.wk.config.filter;


import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lqf
 */

public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, String[]> map =  request.getParameterMap();
        String[] page = map.get("page");
        if(page != null){
            int p = Integer.valueOf(page[0]);
            p = p - 1;
            if(p < 0){
                p = 0;
            }
            Map<String, String[]> newMap = new HashMap<>(map);
            newMap.put("page",new String[]{String.valueOf(p)});
            RequestWrapper requestWrapper = new RequestWrapper(request,newMap);
            servletRequest = requestWrapper;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
