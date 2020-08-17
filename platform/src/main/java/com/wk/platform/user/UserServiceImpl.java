package com.wk.platform.user;

import com.wk.bean.UserInfo;
import com.wk.commonservice.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private CommonService commonService;

    @Override
    public UserInfo findUserInfoByUserId(String userId) {
//        return userInfoRepo.findFirstByUserId(userId);
        String sql = "select * from user_info where user_id=:userId";
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        UserInfo userInfo = commonService.nativeQuery4FirstObject(sql, param, UserInfo.class);
        return userInfo;
    }
}
