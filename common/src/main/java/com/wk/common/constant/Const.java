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
}
