package com.wk.common.util;

import java.util.regex.Pattern;

public class RegUtil {
    private static final String REG_PHONE = "^1[34578]\\d{9}$";
    private static final String REG_STAFFNO = "^[a-z|A-Z|0-9]{1,32}$";

    public static boolean checkPhone(String phone){
        return Pattern.matches(REG_PHONE,phone);
    }
    public static boolean checkStaffNo(String staffNo){
        return Pattern.matches(REG_STAFFNO,staffNo);
    }

    public static void main(String[] args) {
        System.out.println(RegUtil.checkStaffNo("23455.1234"));
    }
}
