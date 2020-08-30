package com.wk.platform.spec;

import com.wk.bean.Spec;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.spec.SpecService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecContoller {
    private final Logger logger = LoggerFactory.getLogger(SpecContoller.class);
    @Autowired
    private SpecService specService;

    @ApiOperation("添加工艺")
    @PostMapping("/spec")
    public Result<Spec> addSpec(Spec spec, String operateUserId){
        try {
            Result<Spec> result = specService.addSpec(spec, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改工艺")
    @PostMapping("/updateSpec")
    public Result<Spec> updateSpec(Spec spec, String operateUserId){
        try {
            Result<Spec> result = specService.updateSpec(spec, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除工艺")
    @PostMapping("/deleteSpec")
    public Result<Spec> deleteSpec(String specId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Spec> result = specService.deleteSpec(specId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下工艺列表")
    @GetMapping("/getSpecList")
    public Result<List<Spec>> getSpecList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return specService.getSpecList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
