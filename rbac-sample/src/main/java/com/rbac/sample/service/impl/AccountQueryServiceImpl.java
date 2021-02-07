package com.rbac.sample.service.impl;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.rbac.sample.common.CommonCodeEnum;
import com.rbac.sample.common.CommonException;
import com.rbac.sample.dao.*;
import com.rbac.sample.model.Account;
import com.rbac.sample.model.AccountRoleRelation;
import com.rbac.sample.model.RolePermissionRelation;
import com.rbac.sample.service.AccountQueryService;
import com.rbac.sample.service.convert.AccountMapper;
import com.rbac.sample.service.convert.PermissionMapper;
import com.rbac.sample.service.convert.RoleMapper;
import com.rbac.sample.service.model.AccountDTO;
import com.rbac.sample.service.model.PermissionDTO;
import com.rbac.sample.service.model.RoleDTO;
import com.rbac.sample.service.request.PageQueryAccountRequest;
import com.rbac.sample.service.response.PageQueryAccountResponse;
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
    public AccountDTO queryAccountById(String accountId) {
        AccountDTO accountDTO = Optional.ofNullable(accountRepository.findByAccountId(accountId))
                .map(AccountMapper.INSTANCE::convert2AccountDTO)
                .orElseThrow(()-> CommonException.of(CommonCodeEnum.SYSTEM_ERROR));
        List<String> roldIdList = Optional.ofNullable(accountRoleRepository.findByAccountId(accountId))
                .orElseGet(ArrayList::new).stream()
                .map(AccountRoleRelation::getRoleId)
                .collect(Collectors.toList());
        List<RoleDTO> roleDTOList = Optional.ofNullable(roleRepository.findByRoleIdIn(roldIdList))
                .orElseGet(ArrayList::new).stream()
                .map(RoleMapper.INSTANCE::convert2RoleDTO)
                .collect(Collectors.toList());
        accountDTO.setRoleList(roleDTOList);
        return accountDTO;
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
