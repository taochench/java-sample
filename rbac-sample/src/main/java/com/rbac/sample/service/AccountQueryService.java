package com.rbac.sample.service;

import com.rbac.sample.service.model.AccountDTO;
import com.rbac.sample.service.request.PageQueryAccountRequest;
import com.rbac.sample.service.response.PageQueryAccountResponse;


/**
 * @version $Id 2020年09月12日 9:42 AccountQueryService.java $Exp
 * @auter taoch
 */
public interface AccountQueryService {

    AccountDTO queryAccountById(String accountId);

    PageQueryAccountResponse pageQueryAccount(PageQueryAccountRequest request);




}
