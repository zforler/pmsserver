package com.wx.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextHolder implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		if(ContextHolder.applicationContext == null){
			ContextHolder.applicationContext  = arg0;
	    }
		System.out.println("========ApplicationContext配置成功,ContextHolder.getAppContext()获取applicationContext对象,applicationContext="+ ContextHolder.applicationContext+"========");
	}
	
	//获取applicationContext
    public static ApplicationContext getApplicationContext() {
       return applicationContext;
    }
    //通过name获取 Bean.
    public static Object getBean(String name){
       return getApplicationContext().getBean(name);
    }
    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
       return getApplicationContext().getBean(clazz);
    }
    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
       return getApplicationContext().getBean(name, clazz);
    }

}
