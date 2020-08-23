package com.wk.config.filter;

import com.wk.config.interceptor.AuthorizationInterceptor;
import com.wk.config.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoggerConfguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册日志拦截器
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns("/error/**","/refresh/**");//swagger-resources
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("**/*.html","/webjars/**","/swagger-resources/**","/v2/**");
        super.addInterceptors(registry);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
