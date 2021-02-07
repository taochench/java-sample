package com.rbac.sample.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version $Id 2020年09月12日 9:52 Result.java $Exp
 * @auter taoch
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T data;

    private boolean success;

    private String resultCode;

    private String resultMsg;


    public static <T> Result<T> ofSuccess(T t){
        Result<T> result = new Result<>();
        result.setData(t);
        result.setSuccess(true);
        result.setResultCode("200");
        result.setResultMsg("执行成功");
        return result;
    }

    public static <T> Result<T> ofFail(CommonCodeEnum codeEnum){
        Result<T> result = new Result<>();
        result.setResultCode(codeEnum.getCodeNo());
        result.setResultMsg(codeEnum.getMsg());
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> ofFail(String code, String msg){
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setResultCode(code);
        result.setResultMsg(msg);
        return result;
    }



}
