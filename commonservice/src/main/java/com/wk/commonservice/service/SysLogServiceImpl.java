package com.wk.commonservice.service;

import com.wk.bean.SysLog;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    private SysLogRepo sysLogRepo;
    @Autowired
    private CommonService commonService;

    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogRepo.saveAndFlush(sysLog);
    }


    @Override
    public Result<PageList<SysLog>> getSysLogPageList(String keyword, String customerId, int page, int size, String operateUserId) {

        String sql = "SELECT * FROM sys_log WHERE user_id LIKE :customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId+"%");

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (user_id LIKE :keyword OR remark LIKE :keyword OR request_uri LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "requestTime");
        Page<SysLog> list = commonService.pageBySql(sql,param,pageable,SysLog.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }
}
