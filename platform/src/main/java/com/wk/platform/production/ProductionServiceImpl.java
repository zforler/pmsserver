package com.wk.platform.production;

import com.wk.bean.Production;
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
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private ProductionRepo productionRepo;

    @Transactional
    @Override
    public Result<Production> addProduction(Production production, String operateUserId) {
        Production p = productionRepo.findFirstByCustomerIdAndProductionNameAndEndTimeEquals(production.getCustomerId(),
                production.getProductionName(),0);
        if(p != null){
            return Result.error("产品名称重复");
        }
        String productionId = seqService.getNextBusinessId(Const.BZ_PRODUCTION, production.getCustomerId(), 4);
        production.setProductionId(productionId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        production.setCreateTime(currentInSecond);
        production.setBeginTime(currentInSecond);
        production.setEndTime(0);
        Production newProd = productionRepo.saveAndFlush(production);

        return Result.success(newProd);
    }

    @Transactional
    @Override
    public Result updateProduction(Production production, String operateUserId) {
        Production p = productionRepo.findFirstByCustomerIdAndProductionNameAndIdNotAndEndTimeEquals(production.getCustomerId(),
                production.getProductionName(),production.getId(),0);
        if(p != null){
            return Result.error("产品名称重复");
        }

        String productionId = production.getProductionId();
        Production old = productionRepo.findById(production.getId());
        if(old == null){
            return Result.error("没有此产品信息");
        }

        String oldName = old.getProductionName();
        String newName = production.getProductionName();
        if(!oldName.equals(newName)){
            int currentInSecond = TimeUtil.getCurrentInSecond();
            productionRepo.updateProductionEndTime(production.getId(),currentInSecond);

            production.setId(0);
            production.setBeginTime(currentInSecond);
            production.setEndTime(0);
            productionRepo.saveAndFlush(production);
        }

        return Result.success();
    }

    @Override
    public Result deleteProduction(String productionId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Production>> getProductionList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT * FROM production WHERE customer_id=:customerId AND end_time=0";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (production_id LIKE :keyword OR production_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Production> productions = commonService.listBySql(sql, param, Production.class);

        return Result.success(productions);

    }
}
