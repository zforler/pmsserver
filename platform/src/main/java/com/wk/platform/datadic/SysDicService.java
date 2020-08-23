package com.wk.platform.datadic;

import com.wk.bean.SysDic;
import com.wk.bean.SysDicItem;
import com.wk.common.vo.Result;

import java.util.List;
import java.util.Map;

public interface SysDicService {
    Result<SysDic> addSysDic(SysDic sysDic, String operateUserId);
    Result<SysDic> updateSysDic(SysDic sysDic,String operateUserId);
    Result deleteSysDic(String code,String operateUserId);
    Result<List<Map<String,Object>>> getSysDicList(String keyword, String operateUserId);

    Result<SysDicItem> addSysDicItem(SysDicItem sysDicItem, String operateUserId);
    Result<SysDicItem> updateSysDicItem(SysDicItem sysDicItem,String operateUserId);
    Result deleteSysDicItem(int id,String operateUserId);
}
