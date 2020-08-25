package com.wk.platform.datadic;

import com.wk.bean.SysDic;
import com.wk.bean.SysDicItem;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDicServiceImpl implements SysDicService {
    @Autowired
    private SysDicRepo sysDicRepo;
    @Autowired
    private SysDicItemRepo dicItemRepo;
    @Autowired
    private SysDicItemRepo sysDicItemRepo;
    @Autowired
    private CommonService commonService;

    @Override
    public Result<SysDic> addSysDic(SysDic sysDic, String operateUserId) {
        SysDic sysDic1 = sysDicRepo.saveAndFlush(sysDic);
        return Result.success(sysDic1);
    }

    @Override
    public Result<SysDic> updateSysDic(SysDic sysDic, String operateUserId) {
        SysDic sysDic1 = sysDicRepo.saveAndFlush(sysDic);
        return Result.success(sysDic1);
    }
    @Transactional
    @Override
    public Result deleteSysDic(String code, String operateUserId) {
        int res = sysDicRepo.deleteAllByCode(code);
        sysDicItemRepo.deleteAllByCode(code);
        return Result.success();
    }

    @Override
    public Result<List<Map<String,Object>>> getSysDicList(String keyword, String operateUserId) {
        String sql = "SELECT sd.code,sd.`name`,sdi.id,sdi.item_code itemCode,sdi.item_name itemName FROM sys_dic sd" +
                " LEFT JOIN sys_dic_item sdi ON sd.code=sdi.code WHERE 1=1";
        Map<String,Object> param = new HashMap<>();
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (sd.code LIKE :keyword OR sd.`name` LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        List<Map<String, Object>> res = commonService.nativeQuery4Map(sql, param);


        return Result.success(res);
    }

    @Override
    public Result<SysDicItem> addSysDicItem(SysDicItem sysDicItem, String operateUserId) {
        SysDicItem sysDicItem1 = dicItemRepo.saveAndFlush(sysDicItem);
        return Result.success(sysDicItem1);
    }

    @Override
    public Result<SysDicItem> updateSysDicItem(SysDicItem sysDicItem, String operateUserId) {
        SysDicItem sysDicItem1 = dicItemRepo.saveAndFlush(sysDicItem);
        return Result.success(sysDicItem1);
    }
    @Transactional
    @Override
    public Result deleteSysDicItem(int id, String operateUserId) {
        sysDicItemRepo.deleteAllById(id);
        return Result.success();
    }
}
