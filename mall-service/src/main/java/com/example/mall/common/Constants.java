package com.example.mall.common;

public final class Constants {
    /**
     * 手机号码正则表达式
     */
    public static final String PHONE_REGEX = "^[1][3,4,5,7,8,9][0-9]{9}$";

    public static final String GRAPH_REGEX = "^.{4}$";

    /**
     * 短信验证码开始值
     */
    public static final int SMS_CODE_BEGIN = 1000;

    /**
     * 短信验证码结束值(不包含)
     */
    public static final int SMS_CODE_END = 10000;

    /**
     * 短信发送成功返回码
     */
    public static final int SMS_SUCCESS_CODE = 0;

    /**
     * 短信发送异常返回码
     */
    public static final int SMS_EXCEPTION_CODE = -1;
}
