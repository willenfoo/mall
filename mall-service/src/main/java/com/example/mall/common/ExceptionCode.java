package com.example.mall.common;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * 系统异常code，避免多系统异常code冲突
 * 一共8位，前3位固定死的，后5位自己写
 */
public enum ExceptionCode implements IErrorCode {

    /** 10 是用户相关 **/
    USER_NOT_EXIST(10000, "商户用户不存在"),
    USER_PASSWORD_ERROR(10001, "密码错误"),

    /** 11 是用户相关 **/
    ORDER_NOT_EXIST(11000, "订单不存在"),
    ;

    ExceptionCode(long code, String msg) {
        this.code = SYSTEM_EXCEPTION_CODE_PREFIX + code;
        this.msg = msg;
    }

    private long code;

    private String msg;

    @Override
    public long getCode() {
        return code;
    }


    @Override
    public String getMsg() {
        return msg;
    }


    /**
     * 系统异常code，code的前缀，防止多系统code冲突
     */
    private static final long SYSTEM_EXCEPTION_CODE_PREFIX = 10000000;

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

