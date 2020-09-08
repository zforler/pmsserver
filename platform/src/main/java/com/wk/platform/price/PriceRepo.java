package com.wk.platform.price;

import com.wk.bean.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepo extends JpaRepository<Price,Integer> {
    Price findFirstByProductionIdAndSpecIdAndTechnologyIdAndShiftIdAndPriceTypeAndCustomerId(String productionId,String specId
            ,String technologyId,String shiftId,int priceType,String customerId);
    Price findFirstByProductionIdAndSpecIdAndTechnologyIdAndShiftIdAndPriceTypeAndCustomerIdAndIdNot(String productionId,String specId
            ,String technologyId,String shiftId,int priceType,String customerId,int id);

    Price findFirstById(int id);

    List<Price> findAllByPriceId(String priceId);
}
