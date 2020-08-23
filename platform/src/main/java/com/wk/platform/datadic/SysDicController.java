package com.wk.platform.datadic;

import com.wk.bean.SysDicItem;
import com.wk.bean.SysDic;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SysDicController {
    private final Logger logger = LoggerFactory.getLogger(SysDicController.class);
    @Autowired
    private SysDicService sysDicService;

    @ApiOperation("添加数据字典")
    @PostMapping("/sysDic")
    public Result<SysDic> addSysDic(SysDic sysDic, String token){
        try {
            String operateUserId = LocalMemCache.getUserByToken(token).getUserId();
            return sysDicService.addSysDic(sysDic, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改数据字典")
    @PostMapping("/updateSysDic")
    public Result<SysDic> updateSysDic(SysDic sysDic, String token){
        try {
            String operateUserId = LocalMemCache.getUserByToken(token).getUserId();
            Result<SysDic> result = sysDicService.updateSysDic(sysDic, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除数据字典")
    @PostMapping("/deleteSysDic")
    public Result<SysDic> deleteSysDic(String code, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<SysDic> result = sysDicService.deleteSysDic(code, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取数据字典列表")
    @GetMapping("/getSysDicList")
    public Result<List<Map<String,Object>>> getSysDicList(String keyword, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return sysDicService.getSysDicList(keyword,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("添加子码")
    @PostMapping("/sysDicItem")
    public Result<SysDicItem> addSysDicItem(SysDicItem sysDicItem, String operateUserId){
        try {
            Result<SysDicItem> result = sysDicService.addSysDicItem(sysDicItem, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改子码")
    @PostMapping("/updateSysDicItem")
    public Result<SysDicItem> updateSysDicItem(SysDicItem sysDicItem, String operateUserId){
        try {
            Result<SysDicItem> result = sysDicService.updateSysDicItem(sysDicItem, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除子码")
    @PostMapping("/deleteSysDicItem")
    public Result<SysDicItem> deleteSysDicItem(int id, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<SysDicItem> result = sysDicService.deleteSysDicItem(id, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
