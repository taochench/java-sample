package com.tcc.sample.dao;

import com.tcc.sample.model.AccountRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version $Id 2020年09月12日 9:45 AccountRoleRepository.java $Exp
 * @auter taoch
 */
public interface AccountRoleRepository extends JpaRepository<AccountRoleRelation, Long> {

    /**
     * 根据账户id查询用户角色关联信息
     * @param accountId
     * @return
     */
    List<AccountRoleRelation> findByAccountId(String accountId);

    /**
     * 根据账户id列表查询用户角色关联信息
     * @param accountList
     * @return
     */
    List<AccountRoleRelation> findAllByAccountIdIn(List<String> accountList);

    /**
     * 根据角色id查询用户角色关联信息
     * @param roleId
     * @return
     */
    List<AccountRoleRelation> findByRoleId(long roleId);



}

