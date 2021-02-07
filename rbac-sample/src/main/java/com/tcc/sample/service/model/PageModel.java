package com.tcc.sample.service.model;

import lombok.Data;

/**
 * @version $Id 2020年09月12日 10:18 PageModel.java $Exp
 * @auter taoch
 */
@Data
public class PageModel {

    /** 默认开始页 */
    public static final int DEFALUT_PAGE = 1;

    /** 默认每页数据量 */
    public static final int DEFALUT_SIZE = 10;

    /** 每页最大数量 */
    public static final int MAX_SIZE = 100;

    /** 当前页 */
    private int page;

    /** 当前页数量 */
    private int size;

    /** 总数据条数 */
    private long total;

    /** 有下一页 */
    private boolean hasNext;

}
