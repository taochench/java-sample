package com.rbac.sample.service.model;

import lombok.Data;

import java.util.List;

/**
 * @version $Id 2021年02月07日 10:20 PageQueryAccountResponse.java $Exp
 * @auter taoch
 */
@Data
public class PageQueryAccountResponse extends PageModel {

    private List<AccountDTO> accountDTOList;

}
