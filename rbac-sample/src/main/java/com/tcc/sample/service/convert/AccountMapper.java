package com.tcc.sample.service.convert;

import com.tcc.sample.common.Constants;
import com.tcc.sample.model.Account;
import com.tcc.sample.service.model.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @version $Id 2021年02月07日 10:41 AccountMapper.java $Exp
 * @auter taoch
 */
@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mappings({
            @Mapping(source = "createTime", target = "createTime", dateFormat = Constants.DEFAULT_DATE_FORMAT),
            @Mapping(source = "updateTime", target = "updateTime", dateFormat = Constants.DEFAULT_DATE_FORMAT)
    })
    AccountDTO convert2AccountDTO(Account account);


}
