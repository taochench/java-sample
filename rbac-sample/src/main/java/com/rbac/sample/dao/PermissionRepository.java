package com.rbac.sample.dao;

import com.rbac.sample.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version $Id 2021年02月07日 10:14 PermissionRepository.java $Exp
 * @auter taoch
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByPermissionIdIn(List<String> permissionIdList);

}
