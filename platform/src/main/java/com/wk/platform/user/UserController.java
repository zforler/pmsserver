package com.wk.platform.user;

import com.wk.bean.Role;
import com.wk.bean.UserInfo;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.config.annotation.IgnoreAuth;
import com.wk.platform.role.RoleController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


//    @GetMapping("/user/{userId}")
//    public Result<UserInfo> findUserInfoByUserId(@PathVariable String userId){
//        UserInfo userInfo = userService.findUserInfoByUserId(userId);
//        return Result.success(userInfo);
//    }
    @IgnoreAuth
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(String userName,String password){
        try {
            return userService.login(userName, password);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("添加用户")
    @PostMapping("/user")
    public Result<UserInfo> addRole(UserInfo userInfo,  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return userService.addUser(userInfo, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改用户")
    @PostMapping("/updateUser")
    public Result<UserInfo> updateUser(UserInfo userInfo,  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return userService.updateUser(userInfo, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取用户分页列表")
    @GetMapping("/getUserPageList")
    public Result<PageList<UserInfo>> getRolePageList(String keyword, int page, int size, String customerId,
                                                  @RequestParam(required = false,defaultValue = "-1") int level,
                                                  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return userService.findUserPageList(keyword, page, size, customerId,level, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePass")
    public Result updatePass(String oldPass,String newPass1,String newPass2,String userId,String customerId,String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return userService.updatePass(oldPass,newPass1,newPass2,userId,customerId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("重置密码")
    @PostMapping("/resetPass")
    public Result resetPass(String userId,String customerId,String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return userService.resetPass(userId,customerId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
