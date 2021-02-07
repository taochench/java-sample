package com.rbac.sample.service.model;

import lombok.Data;

import java.util.List;

/**
 * @version $Id 2020年09月12日 10:49 RoleDTO.java $Exp
 * @auter taoch
 */
@Data
public class RoleDTO extends CommonDTO{

    private String name;

    private String roleNo;

    private List<PermissionDTO> permissionList;

}
