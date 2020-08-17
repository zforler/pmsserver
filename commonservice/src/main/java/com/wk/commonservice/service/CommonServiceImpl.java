package com.wk.commonservice.service;

import org.hibernate.SQLQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private  EntityManager entityManager;


    @Override
    public <T> List<T> listBySql(String sql,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        return resultList;
    }
    @Override
    public <T> List<T> listBySql(String sql,Map<String,Object> params,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        EntityTrans entityTrans = new EntityTrans(c);
        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        return resultList;
    }
    @Override
    public <T> List<T> listBySql(String sql,List params,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        EntityTrans entityTrans = new EntityTrans(c);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }

        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        return resultList;
    }
    @Override
    public <T> Page<T> pageBySql(String sql,Map<String,Object> params,Pageable pageable,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        nativeQuery.setFirstResult((int)pageable.getOffset());
        nativeQuery.setMaxResults(pageable.getPageSize());
        Query countNativeQuery = entityManager.createNativeQuery("select count(*) from ("+sql+") a");
        for (String key: params.keySet()) {
            countNativeQuery.setParameter(key,params.get(key));
        }
        long total = Long.parseLong(String.valueOf(countNativeQuery.getSingleResult()));
        return new PageImpl<T>(nativeQuery.getResultList(),pageable,total);
    }
    @Override
    public <T> Page<T> pageBySql(String sql,List params,Pageable pageable,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        nativeQuery.setFirstResult((int)pageable.getOffset());
        nativeQuery.setMaxResults(pageable.getPageSize());
        Query countNativeQuery = entityManager.createNativeQuery("select count(*) from ("+sql+") a");
        for (int i=0;i<params.size();i++) {
            countNativeQuery.setParameter(i,params.get(i));
        }
        long total = Long.parseLong(String.valueOf(countNativeQuery.getSingleResult()));
        return new PageImpl<T>(nativeQuery.getResultList(),pageable,total);
    }
    @Override
    public <T> Page<T> pageBySql(String sql,Pageable pageable,Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        nativeQuery.setFirstResult((int)pageable.getOffset());
        nativeQuery.setMaxResults(pageable.getPageSize());
        Query countNativeQuery = entityManager.createNativeQuery("select count(*) from ("+sql+") a");
        long total = Long.parseLong(String.valueOf(countNativeQuery.getSingleResult()));
        return new PageImpl<T>(nativeQuery.getResultList(),pageable,total);
    }
    @Override
    public Query getQueryBySql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class);
        return query;
    }

    @Override
    public List<Map<String, Object>> nativeQuery4Map(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }

    @Override
    public List<Map<String, Object>> nativeQuery4Map(String sql, Map<String, Object> params) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
//        System.out.println(nativeQuery.getParameters().size());
        for (String key: params.keySet()) {
//            System.out.println(key);
//            System.out.println(params.get(key));
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }
    @Override
    public Map<String, Object> nativeQuery4OneMap(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        nativeQuery.setFirstResult(0);
        nativeQuery.setMaxResults(1);
        List<Map<String, Object>>  list= nativeQuery.getResultList();
        if(list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Map<String, Object> nativeQuery4OneMap(String sql, Map<String, Object> params) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
//        System.out.println(nativeQuery.getParameters().size());
        for (String key: params.keySet()) {
//            System.out.println(key);
//            System.out.println(params.get(key));
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        nativeQuery.setFirstResult(0);
        nativeQuery.setMaxResults(1);
        List<Map<String, Object>>  list= nativeQuery.getResultList();
        if(list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }
//        return nativeQuery.getResultList();
    }

    @Override
    public Page<Map<String, Object>> nativeQuery4Map(String sql, Map<String, Object> params, Pageable pageable) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
//        System.out.println(nativeQuery.getParameters().size());
        for (String key: params.keySet()) {
//            System.out.println(key);
//            System.out.println(params.get(key));
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        nativeQuery.setFirstResult((int)pageable.getOffset());
        nativeQuery.setMaxResults(pageable.getPageSize());
        Query countNativeQuery = entityManager.createNativeQuery("select count(*) from ("+sql+") a");
        for (String key: params.keySet()) {
            countNativeQuery.setParameter(key,params.get(key));
        }
        long total = Long.parseLong(String.valueOf(countNativeQuery.getSingleResult()));

        return new PageImpl<Map<String, Object>>(nativeQuery.getResultList(),pageable,total);
    }
    public Type standardType(String clazzType){
        if (clazzType.equalsIgnoreCase("java.lang.String")){
            return StandardBasicTypes.STRING;
        }else if (clazzType.equalsIgnoreCase("boolean")|| clazzType.equalsIgnoreCase("java.lang.Boolean")){
            return StandardBasicTypes.BOOLEAN;
        }else if (clazzType.equalsIgnoreCase("int")
                || clazzType.equalsIgnoreCase("java.lang.Integer")){
            return StandardBasicTypes.INTEGER;
        }else if (clazzType.equalsIgnoreCase("long")|| clazzType.equalsIgnoreCase("java.lang.Long")){
            return StandardBasicTypes.LONG;
        }else if (clazzType.equalsIgnoreCase("double")|| clazzType.equalsIgnoreCase("java.lang.Double")){
            return StandardBasicTypes.DOUBLE;
        }else if (clazzType.equalsIgnoreCase("float")|| clazzType.equalsIgnoreCase("java.lang.Float")){
            return StandardBasicTypes.FLOAT;
        }else if (clazzType.equalsIgnoreCase("Timestamp")||clazzType.equalsIgnoreCase("java.lang.Date")){
            return StandardBasicTypes.DATE;
        } else {
            return StandardBasicTypes.STRING;
        }

    }
    @Override
    public <T> T getOneField(String sql,String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
//        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        nativeQuery.setFirstResult(0);
        nativeQuery.setMaxResults(1);
        List<T>  list= nativeQuery.getResultList();
        if(list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public <T> T getOneField(String sql, List params, String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
        nativeQuery.setFirstResult(0);
        nativeQuery.setMaxResults(1);
        List<T>  list= nativeQuery.getResultList();
        if(list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public <T> T getOneField(String sql, Map<String, Object> params, String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
        nativeQuery.setFirstResult(0);
        nativeQuery.setMaxResults(1);
        List<T>  list= nativeQuery.getResultList();
        if(list.size()>0) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public <T> List<T> getOneFieldList(String sql,String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);

        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
//        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<T>  list= nativeQuery.getResultList();
        return list;
    }

    @Override
    public <T> List<T> getOneFieldList(String sql, List params, String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
//        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<T>  list= nativeQuery.getResultList();
        return list;
    }

    @Override
    public <T> List<T> getOneFieldList(String sql, Map<String, Object> params, String field, Class<T> c) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.unwrap(NativeQueryImpl.class).addScalar(field, standardType(c.getName()));
//        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<T>  list= nativeQuery.getResultList();
        return list;
    }

    @Override
    public Page<Map<String, Object>> nativeQuery4Map(String sql, Pageable pageable) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        nativeQuery.setFirstResult((int)pageable.getOffset());
        nativeQuery.setMaxResults(pageable.getPageSize());

        Query countNativeQuery = entityManager.createNativeQuery("select count(*) from ("+sql+") a");
        long total = Long.parseLong(String.valueOf(countNativeQuery.getSingleResult()));

        return new PageImpl<Map<String, Object>>(nativeQuery.getResultList(),pageable,total);
    }
    @Override
    public <T> T nativeQuery4FirstObject(String sql, Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        if(resultList == null || resultList.size() == 0){
            return null;
        }
        try{
            return resultList.get(0);
        }catch (NoResultException e){
            return null ;
        }
    }
    @Override
    public <T> T nativeQuery4FirstObject(String sql,List params, Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        if(resultList == null || resultList.size() == 0){
            return null;
        }
        try{
            return resultList.get(0);
        }catch (NoResultException e){
            return null ;
        }
    }
    @Override
    public <T> T nativeQuery4FirstObject(String sql,Map<String, Object> params, Class<T> c){
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        EntityTrans entityTrans = new EntityTrans(c);
        nativeQuery.unwrap(NativeQueryImpl.class).setResultTransformer(entityTrans);
        List<T> resultList = nativeQuery.getResultList();
        if(resultList == null || resultList.size() == 0){
            return null;
        }
        try{
            return resultList.get(0);
        }catch (NoResultException e){
            return null ;
        }
    }
    @Override
    public Object nativeQuery4UniqueObject(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);

        List results=nativeQuery.getResultList();
        if(results==null || results.size()==0){
            return null;
        }
        try{
            if(results.size()>1){
                throw new RuntimeException("结果应当只有一个，但是发现了"+results.size()+"个。");
            }
            return results.get(0);
        }catch (NoResultException e){
            return null ;
        }

    }
    @Override
    public Object nativeQuery4OneObject(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);

        List results=nativeQuery.getResultList();
        if(results==null || results.size()==0){
            return null;
        }
        try{
            return results.get(0);
        }catch (NoResultException e){
            return null ;
        }

    }

    /**
     * javaBean 转 Map
     * @param object 需要转换的javabean
     * @return  转换结果map
     * @throws Exception
     */
    public static Map<String, Object> beanToMap(Object object) throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();

        Class cls = object.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }
        return map;
    }

    /**
     *
     * @param map   需要转换的map
     * @param cls   目标javaBean的类对象
     * @return  目标类object
     * @throws Exception
     */
    public static Object mapToBean(Map<String, Object> map, Class cls) throws Exception
    {
        Object object = cls.newInstance();
        for (String key : map.keySet()){
            Field temFiels = cls.getDeclaredField(key);
            temFiels.setAccessible(true);
            temFiels.set(object, map.get(key));
        }
        return object;
    }

    /**
     * 执行sql
     * @param sql
     */
    @Override
    public void executeSql(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.executeUpdate();
    }

    @Override
    public void executeSql(String sql, List params) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        for (int i=0;i<params.size();i++) {
            nativeQuery.setParameter(i,params.get(i));
        }
        nativeQuery.executeUpdate();
    }
    @Override
    public void executeSql(String sql, Map<String, Object> params) {
        Query nativeQuery = entityManager.createNativeQuery(sql);

        for (String key: params.keySet()) {
            nativeQuery.setParameter(key,params.get(key));
        }
        nativeQuery.executeUpdate();
    }
}

