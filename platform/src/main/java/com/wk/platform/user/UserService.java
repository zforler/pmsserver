package com.wk.platform.user;

import com.wk.bean.UserInfo;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface UserService {
    Result login(String userName,String password);

    UserInfo findUserInfoByUserId(String userId);

    Result<UserInfo> addUser(UserInfo userInfo,String operateUserId);
    Result<UserInfo> updateUser(UserInfo userInfo,String operateUserId);

    Result<PageList<UserInfo>> findUserPageList(String keyword, int page, int size, String customerId,
                                                int level, String operateUserId);

    Result updatePass(String oldPass,String nwePass1,String newPass2,String userId,String customerId, String operateUserId);
    Result resetPass(String userId,String customerId,String operateUserId);
}
