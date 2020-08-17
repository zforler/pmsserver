package com.wk.platform.user;

import com.wk.bean.UserInfo;
import com.wk.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String helloWorld(){
        return "helloworld";
    }
    @GetMapping("/user/{userId}")
    public Result<UserInfo> findUserInfoByUserId(@PathVariable String userId){
        UserInfo userInfo = userService.findUserInfoByUserId(userId);
        return Result.success(userInfo);
    }
}
