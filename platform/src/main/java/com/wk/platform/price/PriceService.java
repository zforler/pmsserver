package com.wk.platform.price;

import com.wk.bean.Price;
import com.wk.common.vo.Result;

import java.util.List;

public interface PriceService {
    Result<Price> addPrice(Price price, String operateUserId);

    Result updatePrice(Price price,String operateUserId);

    Result deletePrice(String priceId,String operateUserId);

    Result<List<Price>> getPriceList(String keyword, String customerId, String operateUserId);

    Result<List<Price>> getHisPriceList(String priceId, String customerId, String operateUserId);
}
