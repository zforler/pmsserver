package com.wk.platform.spec;

import com.wk.bean.Spec;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecServiceImpl implements SpecService {
    @Autowired
    private SpecRepo specRepo;

    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;

    @Override
    public Result<Spec> addSpec(Spec spec, String operateUserId) {
        Spec tech = specRepo.findByProductionIdAndSpecNameAndEndTimeEquals(spec.getProductionId(),
                spec.getSpecName(),0);
        if(tech != null){
            return Result.error("同一产品规格名称不可重复");
        }
        String specId = seqService.getNextBusinessId(Const.BZ_SPEC, spec.getCustomerId(), 4);
        spec.setSpecId(specId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        spec.setCreateTime(currentInSecond);
        spec.setBeginTime(currentInSecond);
        spec.setEndTime(0);
        Spec newPTech = specRepo.saveAndFlush(spec);

        return Result.success(newPTech);
    }
    @Transactional
    @Override
    public Result updateSpec(Spec spec, String operateUserId) {
        int id = spec.getId();
        Spec tech = specRepo.findByProductionIdAndSpecNameAndIdNotAndEndTimeEquals(spec.getProductionId(),
                spec.getSpecName(),id,0);
        if(tech != null){
            return Result.error("同一产品规格名称不可重复");
        }
        Spec old = specRepo.findFirstById(id);
        if(old == null){
            return Result.error("无此规格");
        }
        String oldName = old.getSpecName();
        String newName = spec.getSpecName();
        if(!oldName.equals(newName)){
            int currentInSecond = TimeUtil.getCurrentInSecond();
            specRepo.updateSpecEndTime(spec.getId(),currentInSecond);

            spec.setId(0);
            spec.setBeginTime(currentInSecond);
            spec.setEndTime(0);
            specRepo.saveAndFlush(spec);
        }

        return Result.success();
    }

    @Override
    public Result deleteSpec(String specId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Spec>> getSpecList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT t.*,p.production_name FROM spec t LEFT JOIN production p ON t.production_id=p.production_id AND p.end_time=0" +
                " WHERE t.customer_id=:customerId AND t.end_time=0";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (spec_id LIKE :keyword OR spec_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Spec> specs = commonService.listBySql(sql, param, Spec.class);

        return Result.success(specs);
    }
}
