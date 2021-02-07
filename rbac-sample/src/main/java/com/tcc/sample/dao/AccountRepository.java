package com.tcc.sample.dao;

import com.tcc.sample.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version $Id 2020年09月12日 9:43 AccountRepository.java $Exp
 * @auter taoch
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
