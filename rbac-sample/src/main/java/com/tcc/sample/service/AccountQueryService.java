package com.tcc.sample.service;

import com.tcc.sample.service.model.AccountDTO;
import com.tcc.sample.service.model.BaseRequest;
import com.tcc.sample.service.model.PageQueryAccountRequest;
import com.tcc.sample.service.model.PageQueryAccountResponse;


/**
 * @version $Id 2020年09月12日 9:42 AccountQueryService.java $Exp
 * @auter taoch
 */
public interface AccountQueryService {

    AccountDTO queryAccountById(BaseRequest request);

    PageQueryAccountResponse pageQueryAccount(PageQueryAccountRequest request);




}
