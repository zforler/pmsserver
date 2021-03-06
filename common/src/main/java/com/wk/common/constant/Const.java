package com.wk.common.constant;

/**
 * @author ssc
 */
public final class Const {

    /**
     * <B>构造方法</B><BR>
     */
    private Const() {
    }
    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String LOGIN_USER_TYPE = "LOGIN_USER_TYPE";
    public static final String LOGIN_TOKEN_KEY = "x-token";
    public static final String LOGIN_TOKEN_PARAM = "token";

    public static final String BZ_ROLE = "ROLE";
    public static final String BZ_USER = "USER";
    public static final String BZ_CUSTOMER = "CUSTOMER";
    public static final String BZ_DEPART = "DEPART";
    public static final String BZ_STAFF = "STAFF";
    public static final String BZ_CARD = "CARD";
    public static final String BZ_PRODUCTION = "PRODUCTION";
    public static final String BZ_TECH = "TECH";
    public static final String BZ_SPEC = "SPEC";
    public static final String BZ_BATCH = "BATCH";
    public static final String BZ_SHIFT = "SHIFT";
    public static final String BZ_PRICE = "PRICE";
    public static final String BZ_EQUIP = "equipment";
    public static final String BZ_EQUIP_SUB = "EQUIPSUB";
    //用户状态
    public static final int USER_STATUS_NORMAL = 0;

    //数据删除
    public static final int DATA_STATUS_DEL = 99;


    //部门类型
    public static final int DEPART_TYPE_DEPART = 1;
    public static final int DEPART_TYPE_WORKSHOP = 3;
    public static final int DEPART_TYPE_GROUP = 3;
    public static final int DEPART_TYPE_STAFF = 4;
    //部门状态
    public static final int DEPART_STATUS_NORMAL = 0;
    public static final int DEPART_STATUS_HISTORY = 1;

    //员工状态
    public static final int STAFF_STATUS_NORMAL = 0;
    public static final int STAFF_STATUS_LEAVE = 1;

    public static final int STAFF_SEX_NAN = 1;
    public static final int STAFF_SEX_NV = 2;

    public static final int STAFF_TYPE_NORMAL = 0;
    public static final int STAFF_TYPE_TEMP = 1;

    //导入类型
    public static final int IMPORT_STAFF = 1;
    public static final int IMPORT_CARD = 2;
    //卡类型
    public static final int CARD_TYPE_STAFF = 1;
    public static final int CARD_TYPE_PRODUCT = 2;
    //工资统计维度
    public static final int SALARY_TYPE_DAY = 1;
    public static final int SALARY_TYPE_MONTH = 2;
    //设备计费维度
    public static final int CALC_STAFF_TYPE = 1;
    public static final int CALC_SHIFT = 2;
    //是否生效
    public static final int ACTIVE = 1;
    public static final int INACTIVE = 0;

    //计费方式
    public static final int PRICE_TYPE_WEIGHT = 1;
    public static final int PRICE_TYPE_COUNT = 2;
    public static final int PRICE_TYPE_TIME = 3;


    //
    public static final String P2C = "P2C";
    public static final String C2P = "C2P";
}
