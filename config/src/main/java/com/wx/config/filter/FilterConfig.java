package com.wx.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lqf
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PageFilter());
        registration.addUrlPatterns("/*");
        registration.setName("PageFilter");
        registration.setOrder(1);
        return registration;
    }

}