package com.rbac.sample.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @version $Id 2020年09月12日 9:18 Role.java $Exp
 * @auter taoch
 */
@Data
@Entity(name = "rbac_role")
public class Role extends BaseEntity{

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 32, nullable = false, unique = true)
    private String roleId;


}
