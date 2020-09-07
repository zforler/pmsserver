package com.wk.common.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.wk.bean.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

public class LocalMemCache {
    private static int expired=65535;

    private static Cache<String, UserInfo> tokenCache =  Caffeine.newBuilder()
            .expireAfterAccess(expired, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public static void addUserToken(String token, UserInfo userInfo){
        tokenCache.put(token, userInfo);
    }
    public static UserInfo getUserByToken(String token){
        return tokenCache.getIfPresent(token);
    }
    public static String getUserIdByToken(HttpServletRequest request){
        String xToken = request.getHeader("x-token");
        return getUserByToken(xToken).getUserId();
    }
    public static String getUserIdByToken(String token){
        return token.substring(token.length() - 8);
//        return getUserByoken(token).getUserId();
    }
    public static void deleteUserToken(String token){
        tokenCache.invalidate(token);
    }

}
