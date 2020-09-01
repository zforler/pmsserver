package com.wk.platform.user;

import com.wk.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepo extends JpaRepository<UserInfo,String> {
    UserInfo findFirstByUserId(String userId);
    UserInfo findFirstByUserNameAndPassword(String userName,String password);
    UserInfo findFirstByUserIdAndPassword(String userId,String password);

    UserInfo findFirstByUserName(String userName);
    UserInfo findFirstByUserNameAndUserIdNot(String userName,String userId);

    @Modifying
    @Query(value = "update user_info set password=?2 where user_id=?1",nativeQuery = true)
    int updatePass(String userId,String pass);
}
