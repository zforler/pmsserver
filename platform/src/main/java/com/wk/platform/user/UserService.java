package com.wk.platform.user;

import com.wk.bean.UserInfo;

public interface UserService {
    UserInfo findUserInfoByUserId(String userId);
}
