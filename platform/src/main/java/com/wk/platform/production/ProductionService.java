package com.wk.platform.production;

import com.wk.bean.Production;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface ProductionService {
    Result<Production> addProduction(Production production, String operateUserId);

    Result updateProduction(Production production,String operateUserId);

    Result deleteProduction(String productionId,String operateUserId);

    Result<List<Production>> getProductionList(String keyword,String customerId, String operateUserId);

}
