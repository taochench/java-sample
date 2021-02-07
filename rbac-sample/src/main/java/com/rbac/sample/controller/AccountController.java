package com.rbac.sample.controller;

import com.rbac.sample.service.request.PageQueryAccountRequest;
import com.rbac.sample.common.PageResult;
import com.rbac.sample.service.AccountQueryService;
import com.rbac.sample.service.model.AccountDTO;
import com.rbac.sample.service.response.PageQueryAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version $Id 2021年02月07日 11:19 AccountController.java $Exp
 * @auter taoch
 */
@RestController(value = "/account")
public class AccountController {

    @Autowired
    private AccountQueryService accountQueryService;

    @GetMapping(value = "/{page}/{size}")
    public PageResult<AccountDTO> queryAccount(@PathVariable("page") int page, @PathVariable("size") int size) {
        PageQueryAccountResponse response = accountQueryService.pageQueryAccount(PageQueryAccountRequest.of(page, size));
        return PageResult.ofSuccess(response.getPage(), response.getSize(),
                response.getTotal(), response.isHasNext(), response.getAccountDTOList());
    }

}
