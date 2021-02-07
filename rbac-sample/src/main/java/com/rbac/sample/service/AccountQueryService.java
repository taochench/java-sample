package com.rbac.sample.service;

import com.rbac.sample.service.model.PageQueryAccountRequest;
import com.rbac.sample.service.model.AccountDTO;
import com.rbac.sample.service.model.BaseRequest;
import com.rbac.sample.service.model.PageQueryAccountResponse;


/**
 * @version $Id 2020年09月12日 9:42 AccountQueryService.java $Exp
 * @auter taoch
 */
public interface AccountQueryService {

    AccountDTO queryAccountById(BaseRequest request);

    PageQueryAccountResponse pageQueryAccount(PageQueryAccountRequest request);




}
