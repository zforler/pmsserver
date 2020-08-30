package com.wk.platform.user;

import com.wk.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo,String> {
    UserInfo findFirstByUserId(String userId);
    UserInfo findFirstByUserNameAndPassword(String userName,String password);

    UserInfo findFirstByUserName(String userName);

    UserInfo findFirstByUserNameAndUserIdNot(String userName,String userId);
}
