package com.tcc.sample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @version $Id 2020年09月12日 9:27 BaseEntity.java $Exp
 * @auter taoch
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 32, nullable = false)
    private Date createTime;

    @Column(length = 32, nullable = false)
    private Date updateTime;

    @Column(nullable = false)
    private boolean enabled;

}
