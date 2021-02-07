package com.rbac.sample.common;

/**
 * @version $Id 2021年02月07日 23:05 CommonException.java $Exp
 * @auter taoch
 */
public class CommonException extends RuntimeException {

    private String code;

    private String msg;

    public CommonException(CommonCodeEnum commonCodeEnum) {
        super(commonCodeEnum.getMsg());
        this.msg = msg;
        this.code = commonCodeEnum.getCodeNo();
    }

    public static CommonException of(CommonCodeEnum commonCodeEnum){
        return new CommonException(commonCodeEnum);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CommonException{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
