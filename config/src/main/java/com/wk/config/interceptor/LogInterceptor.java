package com.wk.config.interceptor;

import com.wk.bean.SysLog;
import com.wk.common.util.GsonUtil;
import com.wk.common.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //把整个log中的参数，交给logUtil来获取，并返回log对象
        SysLog log = null;
        try {
            log = LoggerUtil.getLog(httpServletRequest, o);
            LoggerUtil.setRequestLog(log);
        }catch (Exception e){
            logger.error("logger",e.getMessage());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //返回视图时，插入操作日志
        //LogMapper logMapper = getMapper(LogMapper.class,httpServletRequest);
        SysLog log = LoggerUtil.getRequestLog();

        log =LoggerUtil.updateLog(log,httpServletResponse);

        logger.info(GsonUtil.toJson(log,SysLog.class));
        if(log.getRequestMethod().equalsIgnoreCase("get")){
            LoggerUtil.removeRequestLog();
            return;
        }
        try {
            //保存

//            SysLogService sysLogService= ContextHolder.getBean(SysLogService.class);
//            sysLogService.saveSysLog(log);
        } catch (Exception e1) {
            logger.error(e1.getMessage(),e1);
        }finally {
            LoggerUtil.removeRequestLog();
        }


    }

}
