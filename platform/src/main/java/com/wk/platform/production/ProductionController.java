package com.wk.platform.production;

import com.wk.bean.Production;
import com.wk.bean.ProductionVo;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.production.ProductionService;
import com.wk.platform.role.RoleController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductionController {
    private final Logger logger = LoggerFactory.getLogger(ProductionController.class);
    @Autowired
    private ProductionService productionService;

    @ApiOperation("添加产品")
    @PostMapping("/production")
    public Result<Production> addProduction(Production production, String operateUserId){
        try {
            Result<Production> result = productionService.addProduction(production, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改产品")
    @PostMapping("/updateProduction")
    public Result<Production> updateProduction(Production production, String operateUserId){
        try {
            Result<Production> result = productionService.updateProduction(production, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除产品")
    @PostMapping("/deleteProduction")
    public Result<Production> deleteProduction(String productionId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Production> result = productionService.deleteProduction(productionId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下产品列表")
    @GetMapping("/getProductionList")
    public Result<List<Production>> getProductionList(String keyword,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return productionService.getProductionList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("获取企业下产品列表")
    @GetMapping("/getProductionVoList")
    public Result<List<ProductionVo>> getProductionVoList(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return productionService.getProductionVoList(customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
