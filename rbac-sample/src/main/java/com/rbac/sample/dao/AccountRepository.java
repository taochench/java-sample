package com.rbac.sample.dao;

import com.rbac.sample.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version $Id 2020年09月12日 9:43 AccountRepository.java $Exp
 * @auter taoch
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountId(String accountId);

    List<Account> findByAccountIdIn(List<String> accountIdList);

}
