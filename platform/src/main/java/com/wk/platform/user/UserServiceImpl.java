package com.wk.platform.user;

import com.wk.bean.Customer;
import com.wk.bean.Menus;
import com.wk.bean.Role;
import com.wk.bean.UserInfo;
import com.wk.cache.RedisCacheService;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.constant.Const;
import com.wk.common.util.LoggerUtil;
import com.wk.common.util.MD5Util;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.customer.CustomerRepo;
import com.wk.platform.menu.MenuService;
import com.wk.platform.role.RoleRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public Result login(String userName, String password) {
        String md5Str = MD5Util.getMD5Str(password);
        UserInfo userInfo = userInfoRepo.findFirstByUserNameAndPassword(userName,md5Str);
        if(userInfo == null){
            return Result.error("用户名或密码错误");
        }
        Map<String,Object> res = new HashMap<>();
        res.put("user", userInfo);

        String userId = userInfo.getUserId();
        //生成token
        String token = UUID.randomUUID().toString().replace("-","")+userId;
        LocalMemCache.addUserToken(token,userInfo);

        redisCacheService.addUserInfo(token,userInfo);

        res.put("token", token);

        Customer customer = customerRepo.findFirstByCustomerId(userInfo.getCustomerId());
        res.put("customer", customer);
//        Result<List<Menus>> userMenus = menuService.findUserMenus(userId, "00000000");
//        res.put("menus", userMenus.getData());
        Role role = roleRepo.findFirstByRoleId(userInfo.getRoleId());
        res.put("role", role);
        LoggerUtil.getRequestLog().setUserId(userId);
        return Result.success(res);
    }

    @Override
    public UserInfo findUserInfoByUserId(String userId) {
//        return userInfoRepo.findFirstByUserId(userId);
        String sql = "select * from user_info where user_id=:userId";
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        UserInfo userInfo = commonService.nativeQuery4FirstObject(sql, param, UserInfo.class);
        return userInfo;
    }
    @Transactional
    @Override
    public Result<UserInfo> addUser(UserInfo userInfo, String operateUserId) {
        UserInfo u = userInfoRepo.findFirstByUserName(userInfo.getUserName());
        if(u != null){
            return Result.error("用户名已存在");
        }
        String cusotmerId = userInfo.getCustomerId();
        String userId = seqService.getNextBusinessId(Const.BZ_USER, cusotmerId, 4);
        userInfo.setUserId(userId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        userInfo.setCreateTime(currentInSecond);
        userInfo.setUpdateTime(currentInSecond);
        String password = MD5Util.getMD5Str("12345678");
        userInfo.setPassword(password);
        userInfo.setStatus(Const.USER_STATUS_NORMAL);
        UserInfo newUser = userInfoRepo.saveAndFlush(userInfo);
        return Result.success(newUser);
    }

    @Override
    public Result<UserInfo> updateUser(UserInfo userInfo, String operateUserId) {
        UserInfo u = userInfoRepo.findFirstByUserNameAndUserIdNot(userInfo.getUserName(),userInfo.getUserId());
        if(u != null){
            return Result.error("用户名已存在");
        }
        int currentInSecond = TimeUtil.getCurrentInSecond();
        userInfo.setUpdateTime(currentInSecond);

        UserInfo oldUser = userInfoRepo.findFirstByUserId(userInfo.getUserId());
        userInfo.setCreateTime(oldUser.getCreateTime());
        userInfo.setStatus(oldUser.getStatus());
        userInfo.setPassword(oldUser.getPassword());

        UserInfo newUser = userInfoRepo.saveAndFlush(userInfo);
        return Result.success(newUser);
    }

    @Override
    public Result<PageList<UserInfo>> findUserPageList(String keyword, int page, int size, String customerId, int level, String operateUserId) {
        String sql = "SELECT ui.user_id,ui.customer_id,ui.user_name,ui.real_name,ui.sex,ui.phone," +
                "ui.create_time,ui.update_time,ui.role_id,ui.status,ui.append,r.role_name FROM user_info ui " +
                "LEFT JOIN role r ON ui.role_id=r.role_id WHERE ui.customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (ui.role_id LIKE :keyword OR r.role_name LIKE :keyword OR ui.user_id LIKE :keyword" +
                    " OR ui.user_name LIKE :keyword OR ui.real_name LIKE :keyword OR ui.phone LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "userId");
        Page<UserInfo> list = commonService.pageBySql(sql,param,pageable,UserInfo.class);

        return Result.success(new PageList<UserInfo>(list.getContent(),list.getTotalElements(),page,size));
    }
    @Transactional
    @Override
    public Result updatePass(String oldPass, String newPass1, String newPass2, String userId, String customerId, String operateUserId) {
        if(!newPass1.equals(newPass2)){
            return Result.error("两次新密码不一致");
        }
        UserInfo userInfo = userInfoRepo.findFirstByUserIdAndPassword(userId,MD5Util.getMD5Str(oldPass));
        if(userInfo == null){
            return Result.error("旧密码错误");
        }
        userInfoRepo.updatePass(userId,MD5Util.getMD5Str(newPass1));
        return Result.success();
    }
    @Transactional
    @Override
    public Result resetPass(String userId, String customerId, String operateUserId) {
        userInfoRepo.updatePass(userId,MD5Util.getMD5Str("12345678"));
        return Result.success();
    }
}
