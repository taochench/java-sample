package com.tcc.sample.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @version $Id 2020年09月12日 9:22 Permission.java $Exp
 * @auter taoch
 */
@Data
@Entity(name = "rbac_permission")
public class Permission extends BaseEntity{

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 32, nullable = false, unique = true)
    private String permissionId;

    @Column(length = 32)
    private String type;

}
