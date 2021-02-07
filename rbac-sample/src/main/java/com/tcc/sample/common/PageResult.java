package com.tcc.sample.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version $Id 2021年02月07日 11:20 PageResult.java $Exp
 * @auter taoch
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T>{

    private int pageNum;

    private int pageSize;

    private long total;

    private boolean hasNext;

    private List<T> data;

    private boolean success;

    private String resultCode;

    private String resultMsg;

    public static <T> PageResult<T> ofSuccess(int page, int size, long total, boolean hasNext, List<T> data){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(page);
        pageResult.setPageSize(size);
        pageResult.setTotal(total);
        pageResult.setHasNext(hasNext);
        pageResult.setData(data);
        pageResult.setSuccess(true);
        return pageResult;
    }

    public static <T> PageResult<T> ofFail(CommonCodeEnum codeEnum){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(1);
        pageResult.setPageSize(0);
        pageResult.setTotal(0);
        pageResult.setHasNext(false);
        pageResult.setResultCode(codeEnum.getCodeNo());
        pageResult.setResultMsg(codeEnum.getMsg());
        pageResult.setSuccess(false);
        return pageResult;
    }

    public static <T> PageResult<T> ofFail(String code, String msg){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(1);
        pageResult.setTotal(0);
        pageResult.setPageSize(0);
        pageResult.setHasNext(false);
        pageResult.setSuccess(false);
        pageResult.setResultCode(code);
        pageResult.setResultMsg(msg);
        return pageResult;
    }

}
