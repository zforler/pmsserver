package com.wx.common.constant;

public class TopicConst {
    //center server send message to monitor
    //center server send message to monitor
    public final static String TOPIC_C2M= "TC2M";
    //动态添加主题和删除主题，以及绑定
    public final static String TOPIC_M_ONLINE= "TMONLINE";
    public final static String TOPIC_C_ONLINE= "TCONLINE";
    //monitor send message to center server
    public final static String TOPIC_M2C = "TM2C";

    //center server send message to status service
    public final static String TOPIC_C2S = "TC2S";
    // Asynchronous storage
    public final static String TOPIC_STORAGE = "TSTORAGE";
    public final static String TOPIC_STATUS = "TSTATUS";
    public final static String TOPIC_FAULT = "TFAULT";
    //统计数据
    public final static String TOPIC_ANALYTICS = "TANALYTICS";
    // 交换机 monitor send message to center server
    public final static String EXCHANGE_M2C ="EM2C";
    // 交换机 center server send message to monitor
    public final static String EXCHANGE_C2M ="EC2M";
    public final static String EXCHANGE_DELAY ="EDELAY";
    public final static String TOPIC_DELAY = "DELAY";
    public final static String ROUTING_KEY_DELAY = "";
    public final static String ROUTING_KEY_BROADCAST="FFFFFFFF";
    public final static String EXCHANGE_M_ONLINE ="EMONLINE";
    public final static String EXCHANGE_C_ONLINE ="ECONLINE";
    public final static String EXCHANGE_C2S ="EC2S";
    public final static String EXCHANGE_STORAGE ="ESTORAGE";
    public final static String EXCHANGE_STATUS ="ESTATUS";
    public final static String EXCHANGE_FAULT ="EFAULT";
    //统计数据Exchange
    public final static String EXCHANGE_ANALYTICS ="EANALYTICS";

    public final static String MSG_DADA_CODE ="code";
    public final static String MSG_DADA_BODY ="body";

    //第三方接口消息
    public final static String EXCHANGE_THIRDAPI ="ETHIRDAPI";
    public final static String TOPIC_THIRDAPI = "THIRDAPI";
    public final static String TOPIC_THIRD_EVCS= "THIRDEVCS";
    public final static String EXCHANGE_EVCSAPIMAP="EEVCSMAP";
    public final static String TOPIC_EVCSAPIMAP =  "TEVCSMAP";

    //中电联接口消息
    public final static String EXCHANGE_CEC ="ECEC";
    public final static String TOPIC_CEC = "TCEC";

}
