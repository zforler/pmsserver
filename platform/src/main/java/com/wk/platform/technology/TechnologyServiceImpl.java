package com.wk.platform.technology;

import com.wk.bean.Technology;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    private TechnologyRepo technologyRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;

    @Override
    public Result<Technology> addTechnology(Technology technology, String operateUserId) {
        Technology tech = technologyRepo.findByProductionIdAndTechnologyNameAndEndTimeEquals(technology.getProductionId(),
                technology.getTechnologyName(),0);
        if(tech != null){
            return Result.error("同一产品工艺名称不可重复");
        }
        String technologyId = seqService.getNextBusinessId(Const.BZ_TECH, technology.getCustomerId(), 4);
        technology.setTechnologyId(technologyId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        technology.setCreateTime(currentInSecond);
        technology.setBeginTime(currentInSecond);
        technology.setEndTime(0);
        Technology newPTech = technologyRepo.saveAndFlush(technology);

        return Result.success(newPTech);
    }
    @Transactional
    @Override
    public Result updateTechnology(Technology technology, String operateUserId) {
        int id = technology.getId();
        Technology tech = technologyRepo.findByProductionIdAndTechnologyNameAndIdNotAndEndTimeEquals(technology.getProductionId(),
                technology.getTechnologyName(),id,0);
        if(tech != null){
            return Result.error("同一产品工艺名称不可重复");
        }
        Technology old = technologyRepo.findFirstById(id);
        if(old == null){
            return Result.error("无此工艺");
        }
        String oldName = old.getTechnologyName();
        String newName = technology.getTechnologyName();
        if(!oldName.equals(newName)){
            int currentInSecond = TimeUtil.getCurrentInSecond();
            technologyRepo.updateTechnologyEndTime(technology.getId(),currentInSecond);

            technology.setId(0);
            technology.setBeginTime(currentInSecond);
            technology.setEndTime(0);
            technologyRepo.saveAndFlush(technology);
        }

        return Result.success();
    }

    @Override
    public Result deleteTechnology(String technologyId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Technology>> getTechnologyList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT t.*,p.production_name FROM technology t LEFT JOIN production p ON t.production_id=p.production_id AND p.end_time=0" +
                " WHERE t.customer_id=:customerId AND t.end_time=0";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (technology_id LIKE :keyword OR technology_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Technology> technologys = commonService.listBySql(sql, param, Technology.class);

        return Result.success(technologys);
    }
}
