package com.tcc.sample.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @version $Id 2020年09月12日 9:30 RolePermissionRelation.java $Exp
 * @auter taoch
 */
@Entity
@Data
public class RolePermissionRelation extends BaseEntity {

    @Column(length = 32, nullable = false)
    private String roleId;

    @Column(length = 32, nullable = false)
    private String permissionId;

}
