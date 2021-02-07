package com.rbac.sample.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @version $Id 2020年09月12日 9:24 AccountRoleRelation.java $Exp
 * @auter taoch
 */
@Data
@Entity(name = "rbac_account_role")
public class AccountRoleRelation extends BaseEntity{


    @Column(length = 32, nullable = false)
    private String accountId;

    @Column(length = 32, nullable = false)
    private String roleId;

}
