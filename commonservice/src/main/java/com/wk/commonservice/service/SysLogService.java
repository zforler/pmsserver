package com.wk.commonservice.service;

import com.wk.bean.SysLog;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

public interface SysLogService {
    public void saveSysLog(SysLog sysLog);
    Result<PageList<SysLog>> getSysLogPageList(String keyword, String customerId, int page, int size, String operateUserId);
}
