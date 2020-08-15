package com.wx.commonservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public interface CommonService {

    <T> List<T> listBySql(String sql, Class<T> c);
    <T> List<T> listBySql(String sql, Map<String, Object> params, Class<T> c);
    <T> List<T> listBySql(String sql, List params, Class<T> c);
    <T> Page<T> pageBySql(String sql, Pageable pageable, Class<T> c);
    <T> Page<T> pageBySql(String sql, Map<String, Object> params, Pageable pageable, Class<T> c);
    <T> Page<T> pageBySql(String sql, List params, Pageable pageable, Class<T> c);
    Query getQueryBySql(String sql);
    List<Map<String,Object>> nativeQuery4Map(String sql);
    List<Map<String,Object>> nativeQuery4Map(String sql, Map<String, Object> params);
    Page<Map<String,Object>> nativeQuery4Map(String sql, Map<String, Object> params, Pageable pageable);
    Page<Map<String,Object>> nativeQuery4Map(String sql, Pageable pageable);

    Object nativeQuery4UniqueObject(String sql);
    Object nativeQuery4OneObject(String sql);
    <T> T nativeQuery4FirstObject(String sql, Class<T> c);
    <T> T nativeQuery4FirstObject(String sql, List params, Class<T> c);
    <T> T nativeQuery4FirstObject(String sql, Map<String, Object> params, Class<T> c);
    <T> T getOneField(String sql, String field, Class<T> c);
    <T> T getOneField(String sql, List params, String field, Class<T> c);
    <T> T getOneField(String sql, Map<String, Object> params, String field, Class<T> c);

    <T> List<T> getOneFieldList(String sql, String field, Class<T> c);
    <T> List<T> getOneFieldList(String sql, List params, String field, Class<T> c);
    <T> List<T> getOneFieldList(String sql, Map<String, Object> params, String field, Class<T> c);

    Map<String, Object> nativeQuery4OneMap(String sql);
    Map<String, Object> nativeQuery4OneMap(String sql, Map<String, Object> params);
    void executeSql(String sql);
    void executeSql(String sql, List params);
    void executeSql(String sql, Map<String, Object> params);

}
