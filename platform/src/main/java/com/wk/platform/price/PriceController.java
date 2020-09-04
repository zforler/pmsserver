package com.wk.platform.price;

import com.wk.bean.Price;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.price.PriceController;
import com.wk.platform.price.PriceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {
    private final Logger logger = LoggerFactory.getLogger(PriceController.class);
    @Autowired
    private PriceService priceService;

    @ApiOperation("添加价格")
    @PostMapping("/price")
    public Result<Price> addPrice(Price price, String operateUserId){
        try {
            Result<Price> result = priceService.addPrice(price, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改价格")
    @PostMapping("/updatePrice")
    public Result<Price> updatePrice(Price price, String operateUserId){
        try {
            Result<Price> result = priceService.updatePrice(price, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除价格")
    @PostMapping("/deletePrice")
    public Result<Price> deletePrice(String priceId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Price> result = priceService.deletePrice(priceId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下价格列表")
    @GetMapping("/getPriceList")
    public Result<List<Price>> getPriceList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return priceService.getPriceList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取企业下历史班次列表")
    @GetMapping("/getHisPriceList")
    public Result<List<Price>> getHisPriceList(String priceId, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return priceService.getHisPriceList(priceId,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
