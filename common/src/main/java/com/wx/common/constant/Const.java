package com.wx.common.constant;

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
    //组织机构
    public static final String BUSINESS_TYPE_SUBUNIT = "subunit";
    public static final int BUSINESS_TYPE_SUBUNIT_LEN = 4;
    //场站
    public static final String BUSINESS_TYPE_STATION = "station";
    public static final int BUSINESS_TYPE_STATION_LEN = 2;
    //    0实施 1试运营 2运营中 3维护中 4终止服务
    public static final byte STATION_STATUS_BUILDING = 0;
    public static final byte STATION_STATUS_TEST = 1;
    public static final byte STATION_STATUS_RUNNING = 2;
    public static final byte STATION_STATUS_MAINTAIN = 3;
    public static final byte STATION_STATUS_STOP = 4;
    //运营商状态
    public static final int OPERATOR_STATUS_PENDING=0;//待审核
    public static final int OPERATOR_STATUS_OPERATOR_STATUS_REJECT=1;//驳回
    public static final int OPERATOR_STATUS_NORMAL=2;//正常服务
    public static final int OPERATOR_STATUS_STOP=3;//暂停服务
    public static final int OPERATOR_STATUS_LOCK=4;//锁定
    //充电系统，根据场站6位编码后2位01开始递增
    public static final String BUSINESS_TYPE_CHARGER = "charger";
    public static final int BUSINESS_TYPE_CHARGER_LEN = 2;
    //充电枪，根据充电系统8位编码后2位01开始递增
    public static final String BUSINESS_TYPE_CHARGERGUN = "gun";
    public static final int BUSINESS_TYPE_CHARGERGUN_LEN = 2;
    //用户/客户
    public static final String BUSINESS_TYPE_USER = "user";
    public static final int BUSINESS_TYPE_USER_LEN = 8;
    //账户类型
    public static final int ACCOUNT_TYPE_INDEPENDENT = 0;
    public static final int ACCOUNT_TYPE_UNINDEPENDENT = 1;
    //账户状态
    public static final String ACCOUNT_STATUS_ABNORMAL = "0";
    public static final String ACCOUNT_STATUS_NORMAL = "1";
    public static final byte ACCOUNT_STATUS_ABNORMAL_BYTE = 0;
    public static final byte ACCOUNT_STATUS_NORMAL_BYTE = 1;
    //流水类型
    public static final int JOURNAL_TYPE_CHARGING = 1;
    public static final int JOURNAL_TYPE_RECHARGE = 2;
    //消费来源
    public static final int JOURNAL_SOURCE_PLATFORM = 0x03;
//    public static final int JOURNAL_SOURCE_WXPUBLIC = 1;
//    public static final int JOURNAL_SOURCE_WXMINI = 2;
//    public static final int JOURNAL_SOURCE_ALIPAY = 3;
//    public static final int JOURNAL_SOURCE_APP = 4;
    public static final int JOURNAL_SOURCE_WEIXIN = 0x01;
    public static final int JOURNAL_SOURCE_ALIPAY = 0X02;
    public static final int JOURNAL_SOURCE_UNIONPAY = 0X04;
    public final static String WX = "WX";//微信
    public final static String ALIPAY = "ALIPAY";//支付宝
    public final static String WX_APPLET = "WX_APPLET";//微信小程序
    public final static String ALIPAY_APPLET = "ALIPAY_APPLET";//支付宝小程序

    //退款类型，1个人，2电卡，企业
    public static final int REFUND_TYPE_PERSON = 1;
    public static final int REFUND_TYPE_CARD = 2;
    public static final int REFUND_TYPE_ENTERPRISE = 3;
    //退款渠道，1微信，2后台，3线下
    public static final int REFUND_CHANNEL_WEIXIN = 1;
    public static final int REFUND_CHANNEL_ONLINE = 2;
    public static final int REFUND_CHANNEL_OFFLINE = 3;
    //退款状态，0审核中，1审核通过待支付，2审核拒绝，3退款成功，4退款失败，5取消
    public static final int REFUND_STATUS_TO_APRROVE = 0;
    public static final int REFUND_STATUS_TO_PAY = 1;
    public static final int REFUND_STATUS_REFUSED = 2;
    public static final int REFUND_STATUS_COMPLETE = 3;
    public static final int REFUND_STATUS_FAIL = 4;
    public static final int REFUND_STATUS_CANCELED = 5;

    //电卡
    public static final String BUSINESS_TYPE_CARD = "card";
    public static final int BUSINESS_TYPE_CARD_LEN = 4;
    public static final int CARD_STATUS_NORMAL=0;//	正常
    public static final int CARD_STATUS_FINDBACK=-1;//	解除挂失（找回）
    public static final int CARD_STATUS_LOSS=1;//挂失
    public static final int CARD_STATUS_AUTOUNLOCK=-2;//充值超过透支额度解锁（系统自动）
    public static final int CARD_STATUS_AUTOLOCK=2;//欠费透支锁定（系统自动）
    public static final int CARD_STATUS_UNLOCK=-4;//人工解锁
    public static final int CARD_STATUS_LOCK=4;//人工锁定
    public static final int LOCK_REASON_RELATED = 8;//企业锁定关联锁定

    //车型
    public static final String BUSINESS_TYPE_VECHILEMODEL = "vc";
    public static final int BUSINESS_TYPE_VECHILEMODEL_LEN = 4;
    //车辆
    public static final String BUSINESS_TYPE_VEHICLE = "vehicle";
    public static final int BUSINESS_TYPE_VEHICLE_LEN = 4;
    //费率
    public static final String BUSINESS_TYPE_RATE = "rate";
    public static final int BUSINESS_TYPE_RATE_LEN = 4;
    //名单
    public static final String BUSINESS_TYPE_LIST = "list";
    public static final int BUSINESS_TYPE_LIST_LEN = 4;
    public static final String BUSINESS_TYPE_ROLE = "role";
    public static final int BUSINESS_TYPE_ROLE_LEN = 4;
    public static final int LIST_OPERATE_DELETE=0;
    public static final int LIST_OPERATE_ADD=1;
    //用户/客户 状态
    public static final int USER_STATUS_FREEZE = 0;
    public static final int USER_STATUS_UNFREEZE = 1;
    public static final int USER_STATUS_FREEZE_OVERDRAFT = 3;//透支锁定
    public static final int USER_STATUS_OP_OVERDRAFT = 2;//透支锁定操作
    public static final int USER_STATUS_OP_UNOVERDRAFT = -2;//透支解锁操作
    public static final int USER_STATUS_OP_FREEZE = -1;//锁定操作
    public static final int USER_STATUS_OP_UNFREEZE = 1;//解锁定操作
    public static final int ACTIVE = 1;

    //用户类型0管理员 1个人充电用户 2企业充电用户
    public static final int USER_TYPE_ADMIN = 0;
    public static final int USER_TYPE_CUSTOMER = 1;
    public static final int USER_TYPE_ENTERPRISE = 2;
    // 用户计费类型
    public static final int USER_PAY_TYPE_NOTPAY = 0;
    public static final int USER_PAY_TYPE_PAYBEFORE = 1;
    public static final int USER_PAY_TYPE_PAYAFTER = 2;
    //用户来源0其他 1平台 2App 3微信众号 4 小程序 5第三方
    public static final int USER_SOURCE_PLATFORM = 1;
    public static final int USER_SOURCE_APP = 2;
    public static final int USER_SOURCE_WX_COMMON = 3;
    public static final int USER_SOURCE_WX_MINI = 4;
    public static final int USER_SOURCE_THIRD = 5;
    public static final int USER_SOURCE_OTHER = 0;
    //充电系统黑白名单类型
    public static final int CHARGER_LIST_TYPE_WHITE = 0;
    public static final int CHARGER_LIST_TYPE_BLACK = 1;

    public static final int USER_LEVEL_SYSTEM = 0;
    public static final int USER_LEVEL_AREA = 1;
    public static final int USER_LEVEL_OPERATOR = 2;
    public static final int USER_LEVEL_STATION = 3;
    public static final int USER_LEVEL_ENTERPRISE = 4;
    public static final int USER_LEVEL_SUBUNIT = 5;

    //初始密码
    public static final String INITPASSWORD = "25d55ad283aa400af464c76d713c07ad";
    //系统用户
    public static final int SYSTEMUSER = 0;
    //电卡用户
    public static final int CARDUSER = 1;

    //启动策略
    public static final String BUSINESS_TYPE_POLICYSTARTUP="policyStartup";
    public static final int BUSINESS_TYPE_POLICYSTARTUP_LEN = 8;
    //功率分配策略
    public static final String BUSINESS_TYPE_POLICYDISPATCH="policyDispatch";
    public static final int BUSINESS_TYPE_POLICYDISPATCH_LEN = 8;

    // 费率类型
    public static  final int RATE_TYPE_TIP = 1;
    public static  final int RATE_TYPE_PEAK = 2;
    public static  final int RATE_TYPE_NORMAL = 3;
    public static  final int RATE_TYPE_VALLEY = 4;
    //企业类型
    public static  final short ENTERPRISE_TYPE_INNER = 0;
    public static  final short ENTERPRISE_TYPE_OUTTER = 1;
    //企业是否结算
    public static  final short ENTERPRISE_SETTLE_NO = 0;
    public static  final short ENTERPRISE_SETTLE_YES = 1;
    // 名单验证类型 1	电卡 2车辆Vin 3电卡和车辆Vin 4用户和车辆Vin
    public static  final byte CARD_VALIDATE_C = 1;
    public static  final byte CARD_VALIDATE_V = 2;
    public static  final byte CARD_VALIDATE_CV = 3;
    public static  final byte CARD_VALIDATE_UV = 4;
    // 充电系统状态
    public static  final byte CHARGER_STATU_STOP = 0;
    public static  final byte CHARGER_STATU_RUNNING = 1;
    //枪占位标志
    public static  final byte GUN_OCCUPIED_NO = 0;
    public static  final byte GUN_OCCUPIED_YES = 1;
    //交直流 1直2交
    public static  final byte CHARGER_TYPE_DC = 1;
    public static  final byte CHARGER_TYPE_AC = 2;
    //组织机构操作类型
    public static  final int ES_TYPE_OPERATOR = 1;
    public static  final int ES_TYPE_ES = 2;
    //组织机构类型
    public static final int ESUBUNIT_TYPE_STATION = 1;
    public static final int ESUBUNIT_TYPE_LINE = 2;
    public static final int ESUBUNIT_TYPE_UNIT = 3;

    public static final String CENTER_SERVER ="server-center";
    public static final String MONITOR_SERVER ="server-monitor";
    public static final String THIRDAPI_SERVER ="web-thirdapi";

    //自动启动策略停止方式
    //0——充满；1——定电量；2——定额；3——定时；4——定soc
    public static final byte  POLICY_AUTO_STOP_FULL = 0;
    public static final byte  POLICY_AUTO_STOP_ELEC = 1;
    public static final byte  POLICY_AUTO_STOP_COUNT = 2;
    public static final byte  POLICY_AUTO_STOP_TIME = 3;
    public static final byte  POLICY_AUTO_STOP_SOC = 4;
    //功率分配策略类型
    public static final int DIPATCHPOLICY_TYPE_TIMEFIRST=0;
    public static final int DIPATCHPOLICY_TYPE_AVG=1;
    public static final int DIPATCHPOLICY_TYPE_PRIOPIRST=2;
//    //报表状态
//    public static final byte REPORT_STATUS_NORMAL=0;
//    public static final byte REPORT_STATUS_ABNORMAL=1;

    //订单配置结算类型
    public static final int SETTLEMENT_CONFIG_TYPE_PERIOD=1;//周期
    public static final int SETTLEMENT_CONFIG_TYPE_FIX=2;//定期

    //资源关联表类型
    //结算单电子凭证类型
//    public static final byte FDFS_RELEVANCY_SETTLEMENT = 2;

    //结算订单状态
    public static final byte PAY_SETTLEMENT_STATUS_TO_BE_PAID = 0;
    public static final byte PAY_SETTLEMENT_STATUS_TO_BE_CONFIRMED = 1;
    public static final byte PAY_SETTLEMENT_STATUS_COMPLETED = 2;
    public static final byte PAY_SETTLEMENT_STATUS_ABNORMAL_ENTERPRISE = 3;
    public static final byte PAY_SETTLEMENT_STATUS_ABNORMAL_OPERATOR = 4;
    public static final byte PAY_SETTLEMENT_STATUS_TO_BE_CONFIRMED_ABNORMAL = 5;
    public static final byte PAY_SETTLEMENT_STATUS_COMPLETED_ABNORMAL = 6;
    public static final byte PAY_SETTLEMENT_STATUS_TO_BE_PAID_ABNORMAL = 7;

    //结算订单类型
    public static final byte PAY_SETTLEMENT_TYPE_ABNORMAL = 0;
    public static final byte PAY_SETTLEMENT_TYPE_NORMAL = 1;

    //结算单设置类型
    public static final byte PAY_SETTLEMENT_CONFIG_TYPE_REGULAR = 1;
    public static final byte PAY_SETTLEMENT_CONFIG_TYPE_PERIOD = 2;

    //资源关联 1运营商 2场站 3车辆 4结算凭证 5中电联场站
    public static final byte FDFS_RELEVANCY_OPERATOR=1;
    public static final byte FDFS_RELEVANCY_STATION=2;
    public static final byte FDFS_RELEVANCY_VEHICLE=3;
    public static final byte FDFS_RELEVANCY_SETTLEMENT=4;
    public static final byte FDFS_RELEVANCY_CEC_STATION=5;

    //修改密码验证类型
    public static final String VALIDATE_EMAIL = "1";
    public static final String VALIDATE_PHONE = "2";

    public static final String VALIDATE_STATUS_OPERATOR="operator";
    public static final String VALIDATE_STATUS_ENTERPRISE="enterprise";
    public static final String VALIDATE_STATUS_USER="user";
    //企业状态 0正常1锁定
    public static final short ENTERPRISE_STATUS_NORMAL = 0;
    public static final short ENTERPRISE_STATUS_ABNORMAL = 1;
    //报表状态 0未发布 1停用 2发布
    public static final int REPORT_STATUS_INIT=0;
    public static final int REPORT_STATUS_STOP=1;
    public static final int REPORT_STATUS_PUBLISH=2;

    // 状态操作
    public static final int REJECT_CHARGE = 1;
    public static final int REJECT_STATION = 2;
    public static final int REJECT_OPERATOR = 3;

    public static final String ZERO_STRING = "0";

    //充电机握手黑名单
    public static final String COUNT_MSG_TYPE_HANDLE="handle";
    public static final String COUNT_MSG_TYPE_FAULT="fault";
    public static final String COUNT_MSG_TYPE_GUNSTATUS="gunstat";
    public static final String COUNT_MSG_TYPE_CHARGERSTATUS="chargerstat";
    public static final int COUNT_MSG_TYPE_HANDLE_MAX=10;
    public static final int COUNT_MSG_TYPE_FAULT_MAX=10;
    public static final int COUNT_MSG_TYPE_GUNSTATUS_MAX=30;
    public static final int COUNT_MSG_TYPE_CHARGERSTATUS_MAX=10;
    public static final int COUNT_MSG_TYPE_TIME=30;
    //黑名单保持时间1小时
    public static final int BLACK_LIST_TIME=60*60;
    public static final int BLACK_LIST_TIME_MSG_GUNSTATUS=5*60;

    public static final String WX_PUBLIC_PASSWORD = "123456";

    //充电订单缓存时间
    public static final int CHARGE_ORDER_TIME=12*60;
    //第三方是否支持ssl
    public final static int SSL_SUPPORT = 1;
    public final static int SSL_UNSUPPORT = 0;
    //第三方充电机是否推送数据
    public final static int THIRD_CHARGER_UNPUSH = 0x00;
    public final static int THIRD_CHARGER_PUSH = 0x01;

    public static int COMMAND_RESULT_SUCCESS = 0x00;//成功
    public static int COMMAND_RESULT_START_OVER = 0x01;//已启动
    public static int COMMAND_RESULT_RESERVER_OVER = 0x02;//已预约
    public static int COMMAND_RESULT_OFFLINE = 0x03;//离线
    public static int COMMAND_RESULT_UNCONNECTED = 0x04;//未插枪
    public static int COMMAND_RESULT_UNDEFINED = 0xFF;//未知

    public final static int COMMAND_START = 0x01;
    public final static int COMMAND_STOP = 0x02;
    //报表类型
    public final static byte REPORT_TYPE_COMMON=0;//通用型
    public final static byte REPORT_TYPE_AUTH=1;  //授权型
    public final static byte REPORT_TYPE_LIMIT=2; //受限型

}
