package com.rbac.sample.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @version $Id 2020年09月12日 9:14 Account.java $Exp
 * @auter taoch
 */
@Data
@Entity(name = "rbac_account")
public class Account extends BaseEntity{

    @Column(length = 32, nullable = false, unique = true)
    private String accountId;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean locked;


}
