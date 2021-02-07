package com.tcc.sample.service.convert;

import com.tcc.sample.common.Constants;
import com.tcc.sample.model.Permission;
import com.tcc.sample.service.model.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @version $Id 2021年02月07日 11:12 PermissionMapper.java $Exp
 * @auter taoch
 */
@Mapper
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    @Mappings({
            @Mapping(source = "createTime", target = "createTime", dateFormat = Constants.DEFAULT_DATE_FORMAT),
            @Mapping(source = "updateTime", target = "updateTime", dateFormat = Constants.DEFAULT_DATE_FORMAT)
    })
    PermissionDTO convert2PermissionDTO(Permission permission);

}
