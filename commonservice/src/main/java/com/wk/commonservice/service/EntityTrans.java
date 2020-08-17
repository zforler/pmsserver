package com.wk.commonservice.service;


import org.hibernate.transform.AliasToBeanResultTransformer;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class EntityTrans extends AliasToBeanResultTransformer {
    private Class resultClass;
    public EntityTrans(Class resultClass) {
        super(resultClass);
        this.resultClass = resultClass;
    }

    private static final long serialVersionUID = 1L;
    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
//        List list = new ArrayList();
        Object obj = null;
        try {
            obj = resultClass.newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }

        Method[] methods = resultClass.getMethods();// 返回这个类里面方法的集合
        for(int k=0;k<aliases.length;k++){
            String aliase=aliases[k];
            char[] ch = aliase.toCharArray();
            ch[0] = Character.toUpperCase(ch[0]);
            String s =upperCaseFirstChar(aliase);
            String[] names = new String[] { ("set" + s).intern(),
                    ("get" + s).intern(), ("is" + s).intern(),
                    ("read" + s).intern() };
            Method setter = null;
            Method getter = null;
            int length = methods.length;
            for (int i = 0; i < length; ++i) {
                Method method = methods[i];
                /**
                 * 检查该方法是否为公共方法,如果非公共方法就继续
                 */
                if(!Modifier.isPublic(method.getModifiers()))
                    continue;
                String methodName = method.getName();

                for (String name : names) {
                    if (name.equals(methodName)) {
                        if (name.startsWith("set") || name.startsWith("read"))
                            setter = method;
                        else if (name.startsWith("get") || name.startsWith("is"))
                            getter = method;

                    }
                }
            }
            if(getter!=null){
                String paramType=getter.getReturnType().getName();
                if(paramType.equalsIgnoreCase("java.lang.Object")){
                   Class genericClass=resultClass;
                   Type type= null;

                    while(genericClass.getSuperclass() != Object.class){

                        type =genericClass.getGenericSuperclass();
                        if(type instanceof ParameterizedType  && hasMethod(genericClass.getSuperclass(),getter.getName())  ){
                            break;
                        }
                        genericClass = genericClass.getSuperclass();

                    }
                    if (type!=null && type instanceof ParameterizedType) {
                        Type[] p = ((ParameterizedType) type).getActualTypeArguments();
                        paramType=p[0].getTypeName();
                    }
                }

                Object[] param = buildParam(paramType, tuple[k]);
                try {
                    setter.invoke(obj, param);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
//        list.add(obj);
//        return list;
        return obj;
    }
    public boolean  hasMethod(final Class<?> clazz, final String methodName) {


        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }
    private final static Object[] buildParam(String paramType, Object value) {
        Object[] param = new Object[1];
        if (paramType.equalsIgnoreCase("java.lang.String")) {
            if(value==null){
                param[0]=null;
            }else {
                param[0] = String.valueOf(value);
            }
        } else if (paramType.equalsIgnoreCase("boolean")|| paramType.equalsIgnoreCase("java.lang.Boolean")) {
            if(value==null){
                param[0]= false;
            }else if(value instanceof Boolean){
               param[0] = (Boolean)(value);
           }else {
               param[0] =Long.valueOf(value.toString()) >0;
           }
        } else if (paramType.equalsIgnoreCase("int")
                || paramType.equalsIgnoreCase("java.lang.Integer")) {
            if(value==null){
                param[0] = 0;
            } else {
                if(value instanceof Boolean){
                    if((Boolean)(value)){
                        param[0]=1;
                    }else {
                        param[0]=0;
                    }

                }else {
                    param[0] = Integer.parseInt(value.toString());//避免java.math.BigInteger cannot be cast to java.lang.Integer
                }
            }

        } else if (paramType.equalsIgnoreCase("long")|| paramType.equalsIgnoreCase("java.lang.Long")) {
            if(value==null){
                param[0] = 0;
            } else if (value instanceof Timestamp){
                param[0] = ((Timestamp)value).getTime();//避免java.math.BigInteger cannot be cast to java.lang.Long
            }else {
                param[0] = Long.parseLong(value.toString());//避免java.math.BigInteger cannot be cast to java.lang.Long
            }
        } else if (paramType.equalsIgnoreCase("double")|| paramType.equalsIgnoreCase("java.lang.Double")) {
            if(value==null){
                param[0] = 0;
            } else {
                param[0] = (Double) (value);
            }
        } else if (paramType.equalsIgnoreCase("float")|| paramType.equalsIgnoreCase("java.lang.Float")) {
            if(value==null){
                param[0] = 0;
            } else {
                param[0] = (Float) (value);
            }
        } else if (paramType.equalsIgnoreCase("char")
                || paramType.equalsIgnoreCase("Character")) {
            param[0] = (char)(value);
        } else if (paramType.equalsIgnoreCase("Timestamp")) {
            if(value==null){
                param[0] = 0;
            } else if (value instanceof Date){
                param[0] = new Timestamp(((Date)value).getTime());
            }else  if(paramType.equalsIgnoreCase("java.lang.String")){
                param[0]=Timestamp.valueOf(value.toString());
            }else {
                param[0] = (Timestamp) value;
            }
        } else if(paramType.equalsIgnoreCase("java.math.BigDecimal")){
            param[0] = (BigDecimal)value;
        } else if(paramType.equalsIgnoreCase("java.util.Date")){
            param[0] = (Date) value;
        }
        return param;
    }
    public String upperCaseFirstChar(String s){
        StringBuffer sb=new StringBuffer();
        char[] ch = s.toCharArray();
        boolean b=false;
        for(int i=0;i<s.length();i++){
            if(i==0){
                b=true;
            }
            if(ch[i]=='_'){
                b=true;
            }
            if(b && ch[i]!='_'){
                sb.append(Character.toUpperCase(ch[i]));
                b=false;
            }else if(ch[i]!='_'){
                sb.append(ch[i]);
            }

        }
        return sb.toString();

    }
}
