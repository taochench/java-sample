package com.rbac.sample.service.model;

import lombok.Data;

import java.util.List;

/**
 * @version $Id 2020年09月12日 10:47 AccountDTO.java $Exp
 * @auter taoch
 */
@Data
public class AccountDTO extends CommonDTO{

    /** 账户ID */
    private String accountId;

    /** 账户密码 */
    private String password;

    /** 账户启用 */
    private boolean enabled;

    /** 账户锁定 */
    private boolean lock;

    /** 角色列表 */
    private List<RoleDTO> roleList;

    /** 权限列表（直接挂靠在账户下的权限） */
//    private List<PermissionDTO> permissionList;

}
