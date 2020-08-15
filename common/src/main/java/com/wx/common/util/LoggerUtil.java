package com.wx.common.util;

import com.wx.bean.SysLog;
import com.wx.common.constant.Const;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoggerUtil {
    private static final ThreadLocal<SysLog> REQUEST_LOG = new ThreadLocal<>();

    public LoggerUtil(){}

    public static SysLog getRequestLog() {
        return REQUEST_LOG.get();
    }
    public static void setRequestLog(SysLog log) {
         REQUEST_LOG.set(log);
    }

    public static void removeRequestLog(){
        REQUEST_LOG.remove();
    }

    public static SysLog getLog(HttpServletRequest request, Object o){
        //1.依次获取每个属性信息 userId,operator,action,remark,ip,targetType
        SysLog log = new SysLog();
        log.setClientIp(LoggerUtil.getCliectIp(request));
        log.setRequestUri(request.getRequestURI());
        log.setRequestMethod(request.getMethod());

        //获取注解中的方法描述
        HandlerMethod method = (HandlerMethod)o;
        ApiOperation apiOperation = method.getMethod().getAnnotation(ApiOperation.class);
        if(apiOperation != null){
            log.setRemark(apiOperation.value());
        }else{
            log.setRemark(request.getRequestURI());
        }

        String paramData= GsonUtil.toJson(request.getParameterMap(), Map.class);
//        String token=request.getParameter("token");
        String token=request.getHeader(Const.LOGIN_TOKEN_KEY);
        if(StringUtils.isBlank(token)){
            try {
                token = request.getParameterMap().get(Const.LOGIN_TOKEN_PARAM)[0];
            }catch (Exception e){

            }
        }
        String userTypeId="";
        if(!StringUtils.isBlank(token)){
            log.setUserId(getUserIdByToken(token));
        }else {

            log.setUserId(null);
        }
        log.setParamData(paramData);

        log.setRequestTime(TimeUtil.getCurrentInMillis());
        return log;
    }
    public static String getUserIdByToken(String token){
        if(StringUtils.isBlank(token)){
            return null;
        }else {
            return token.substring(32);
        }
    }
    public static SysLog updateLog(SysLog log, HttpServletResponse response){
        int status = response.getStatus();
        long currentTime=System.currentTimeMillis();

        if (log != null) {
            long requestTime=log.getRequestTime();
            log.setOperateTime(currentTime-requestTime);
            log.setReturnTime(currentTime);
            log.setHttpStatus(status+"");
            log.setReportTime(TimeUtil.getCurrentInSecond());


        }
        return  log;
    }
    /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;

    }

}
