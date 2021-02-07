package com.rbac.sample.common;

import lombok.Getter;;

/**
 * @version $Id 2020年09月12日 9:57 CommonCodeEnum.java $Exp
 * @auter taoch
 */
@Getter
public enum CommonCodeEnum {

    SUCCESS("200","成功","SUCCESS"),
    NET_ERROR("500","网络异常，请稍后再试","NET_ERROR"),
    NO_PERMISSION("100","无权限","NO_PERMISSION"),
    SYSTEM_ERROR("500","系统异常","SYSTEM_ERROR"),
    ;

    /** code */
    private String codeNo;

    /** 信息 */
    private String msg;

    /** 编码 */
    private String code;

    CommonCodeEnum(String codeNo, String msg, String code) {
        this.codeNo = codeNo;
        this.msg = msg;
        this.code = code;
    }
}
