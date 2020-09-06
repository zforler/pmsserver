package com.wk.platform.sysLog;

import com.wk.bean.SysLog;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.SysLogService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogController {
    private final Logger logger = LoggerFactory.getLogger(SysLogController.class);
    @Autowired
    private SysLogService sysLogService;
    
    @ApiOperation("获取操作日志分页列表")
    @GetMapping("/getSysLogPageList")
    public Result<PageList<SysLog>> getSysLogPageList(String keyword,String customerId, int page, int size, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return sysLogService.getSysLogPageList(keyword,customerId, page, size, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
