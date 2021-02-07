package com.tcc.sample.service.convert;

import com.tcc.sample.common.Constants;
import com.tcc.sample.model.Role;
import com.tcc.sample.service.model.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @version $Id 2021年02月07日 11:03 RoleMapper.java $Exp
 * @auter taoch
 */
@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
            @Mapping(source = "createTime", target = "createTime", dateFormat = Constants.DEFAULT_DATE_FORMAT),
            @Mapping(source = "updateTime", target = "updateTime", dateFormat = Constants.DEFAULT_DATE_FORMAT)
    })
    RoleDTO convert2RoleDTO(Role role);

}
