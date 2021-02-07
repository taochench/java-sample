package com.rbac.sample.dao;

import com.rbac.sample.model.RolePermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version $Id 2020年09月12日 9:47 RolePermissionRepository.java $Exp
 * @auter taoch
 */
public interface RolePermissionRepository extends JpaRepository<RolePermissionRelation, Long> {

    /**
     * 根据角色id查询关系数据
     * @param roleId
     * @return
     */
    List<RolePermissionRelation> findByRoleId(String roleId);

    /**
     * 根据权限id查询关系数据
     * @param permissionId
     * @return
     */
    List<RolePermissionRelation> findByPermissionId(String permissionId);



}
