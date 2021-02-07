package com.tcc.sample.service.impl;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.tcc.sample.dao.*;
import com.tcc.sample.model.Account;
import com.tcc.sample.model.AccountRoleRelation;
import com.tcc.sample.model.RolePermissionRelation;
import com.tcc.sample.service.AccountQueryService;
import com.tcc.sample.service.convert.AccountMapper;
import com.tcc.sample.service.convert.PermissionMapper;
import com.tcc.sample.service.convert.RoleMapper;
import com.tcc.sample.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @version $Id 2021年02月07日 10:12 AccountQueryServiceImpl.java $Exp
 * @auter taoch
 */
@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public AccountDTO queryAccountById(BaseRequest request) {
        return null;
    }

    @Override
    public PageQueryAccountResponse pageQueryAccount(PageQueryAccountRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        Page<Account> accountPage = accountRepository.findAll(pageRequest);
        ArrayList<String> accountIdList = new ArrayList<>();
        List<AccountDTO> accountDTOList = accountPage.stream()
                .peek(a -> accountIdList.add(a.getAccountId()))
                .map(AccountMapper.INSTANCE::convert2AccountDTO)
                .collect(Collectors.toList());
        ListMultimap<String, String> multimap = Optional.ofNullable(accountRoleRepository.findAllByAccountIdIn(accountIdList))
                .orElseGet(ArrayList::new)
                .stream()
                .collect(Multimaps.toMultimap(AccountRoleRelation::getAccountId,
                        AccountRoleRelation::getRoleId, MultimapBuilder.hashKeys().arrayListValues()::build));
        for (AccountDTO accountDTO : accountDTOList) {
            List<String> roldIdList = multimap.get(accountDTO.getAccountId());
            List<RoleDTO> roleList = Optional.ofNullable(roleRepository.findByRoleIdIn(roldIdList))
                    .orElseGet(ArrayList::new)
                    .stream().map(RoleMapper.INSTANCE::convert2RoleDTO)
                    .peek(role -> {
                        List<String> permissionIdList = Optional.ofNullable(rolePermissionRepository.findByRoleId(role.getRoleNo()))
                                .orElseGet(ArrayList::new)
                                .stream()
                                .map(RolePermissionRelation::getPermissionId)
                                .collect(Collectors.toList());
                        List<PermissionDTO> permissionDTOList = Optional.ofNullable(permissionRepository.findByPermissionIdIn(permissionIdList))
                                .orElseGet(ArrayList::new).stream()
                                .map(PermissionMapper.INSTANCE::convert2PermissionDTO)
                                .collect(Collectors.toList());
                        role.setPermissionList(permissionDTOList);
                    })
                    .collect(Collectors.toList());
            accountDTO.setRoleList(roleList);
        }
        PageQueryAccountResponse response = new PageQueryAccountResponse();
        response.setAccountDTOList(accountDTOList);
        Pageable pageable = accountPage.getPageable();
        response.setPage(pageable.getPageNumber());
        response.setSize(accountDTOList.size());
        response.setTotal(accountPage.getTotalElements());
        response.setHasNext(accountPage.hasNext());
        return response;
    }
}
