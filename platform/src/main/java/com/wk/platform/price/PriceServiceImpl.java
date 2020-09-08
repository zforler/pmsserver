package com.wk.platform.price;

import com.wk.bean.Price;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepo priceRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;

    @Override
    public Result<Price> addPrice(Price price, String operateUserId) {
        String customerId = price.getCustomerId();
        Price old = priceRepo.findFirstByProductionIdAndSpecIdAndTechnologyIdAndShiftIdAndPriceTypeAndCustomerId(price.getProductionId()
                , price.getSpecId(), price.getTechnologyId(), price.getShiftId(),price.getPriceType(), customerId);
        if(old != null){
            return Result.error("计价规则重复");
        }
        int second = TimeUtil.getCurrentInSecond();
        String priceId = seqService.getNextBusinessId(Const.BZ_PRICE, customerId, 4);
        price.setPriceId(priceId);
        price.setCreateTime(second);
        price.setUpdateTime(second);
        price.setReactiveTime(0);
        Price newPrice = priceRepo.saveAndFlush(price);
        return Result.success(newPrice);
    }

    @Override
    public Result updatePrice(Price price, String operateUserId) {
        Price old = priceRepo.findFirstById(price.getId());
        if(old == null){
            return Result.error("无此计价规则");
        }
        String customerId = price.getCustomerId();
        Price old1 = priceRepo.findFirstByProductionIdAndSpecIdAndTechnologyIdAndShiftIdAndPriceTypeAndCustomerIdAndIdNot(price.getProductionId()
                , price.getSpecId(), price.getTechnologyId(), price.getShiftId(),price.getPriceType(), customerId,price.getId());
        if(old1 != null){
            return Result.error("计价规则重复");
        }
        int second = TimeUtil.getCurrentInSecond();
        price.setUpdateTime(second);
        float oldPrice = old.getPrice();
        float newPrice = price.getPrice();
        if(oldPrice != newPrice){
            old.setReactiveTime(second);
            old.setUpdateTime(second);
            priceRepo.saveAndFlush(old);
            price.setId(0);
        }
        price.setSendTime(old.getSendTime());
        price.setStatus(old.getStatus());
        price.setActiveTime(second);
        price.setReactiveTime(0);
        priceRepo.saveAndFlush(price);
        return Result.success();
    }

    @Override
    public Result deletePrice(String priceId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Price>> getPriceList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT p.*,pd.production_name,s.spec_name,t.technology_name,sh.shift_name FROM price p LEFT JOIN" +
                " production pd ON p.production_id=pd.production_id AND pd.end_time=0 LEFT JOIN spec s ON p.spec_id=s.spec_id AND s.end_time=0 " +
                "LEFT JOIN technology t ON p.technology_id=t.technology_id AND t.end_time=0 LEFT JOIN shift sh ON" +
                " p.shift_id=sh.shift_id AND sh.reactive_time=0 WHERE p.customer_id=:customerId and p.reactive_time=0";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (p.price_id LIKE :keyword OR pd.production_name LIKE :keyword OR s.spec_name LIKE :keyword" +
                    " OR t.technology_name LIKE :keyword  OR sh.shift_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Price> prices = commonService.listBySql(sql, param, Price.class);

        return Result.success(prices);
    }

    @Override
    public Result<List<Price>> getHisPriceList(String priceId, String customerId, String operateUserId) {
        String sql = "SELECT p.*,pd.production_name,s.spec_name,t.technology_name,sh.shift_name FROM price p LEFT JOIN" +
                " production pd ON p.production_id=pd.production_id AND pd.end_time=0 LEFT JOIN spec s ON p.spec_id=s.spec_id AND s.end_time=0 " +
                "LEFT JOIN technology t ON p.technology_id=t.technology_id AND t.end_time=0 LEFT JOIN shift sh ON" +
                " p.shift_id=sh.shift_id AND sh.reactive_time=0 WHERE p.customer_id=:customerId and p.price_id=:priceId";

        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        param.put("priceId",priceId);

        List<Price> prices = commonService.listBySql(sql, param, Price.class);

        return Result.success(prices);
    }
}
