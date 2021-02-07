package com.rbac.sample.dao;

import com.rbac.sample.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version $Id 2020年09月12日 9:43 RoleRepository.java $Exp
 * @auter taoch
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleId(String roleId);

    List<Role> findByRoleIdIn(List<String> roleIdList);

}
