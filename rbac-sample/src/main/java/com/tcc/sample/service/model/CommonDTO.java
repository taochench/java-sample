package com.tcc.sample.service.model;

import lombok.Data;

/**
 * @version $Id 2021年02月07日 9:57 CommonDTO.java $Exp
 * @auter taoch
 */
@Data
public class CommonDTO {

    /** 数据主键 */
    private long id;

    /** 数据创建时间 */
    private String createTime;

    /** 更新时间 */
    private String updateTime;

}
