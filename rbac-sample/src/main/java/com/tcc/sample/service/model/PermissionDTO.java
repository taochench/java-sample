package com.tcc.sample.service.model;

import lombok.Data;

/**
 * @version $Id 2020年09月12日 10:50 PermissionDTO.java $Exp
 * @auter taoch
 */
@Data
public class PermissionDTO extends CommonDTO{

    private String name;

    private String permissionNo;

    private String type;

}
