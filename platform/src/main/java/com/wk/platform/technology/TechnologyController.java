package com.wk.platform.technology;

import com.wk.bean.Technology;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.technology.TechnologyController;
import com.wk.platform.technology.TechnologyService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnologyController {
    private final Logger logger = LoggerFactory.getLogger(TechnologyController.class);
    @Autowired
    private TechnologyService technologyService;

    @ApiOperation("添加工艺")
    @PostMapping("/technology")
    public Result<Technology> addTechnology(Technology technology, String operateUserId){
        try {
            Result<Technology> result = technologyService.addTechnology(technology, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改工艺")
    @PostMapping("/updateTechnology")
    public Result<Technology> updateTechnology(Technology technology, String operateUserId){
        try {
            Result<Technology> result = technologyService.updateTechnology(technology, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除工艺")
    @PostMapping("/deleteTechnology")
    public Result<Technology> deleteTechnology(String technologyId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Technology> result = technologyService.deleteTechnology(technologyId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下工艺列表")
    @GetMapping("/getTechnologyList")
    public Result<List<Technology>> getTechnologyList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return technologyService.getTechnologyList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
