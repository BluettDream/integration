package org.blue.springbootmodular.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.blue.springbootmodular.entity.Account;
import org.blue.springbootmodular.mapper.AccountMapper;
import org.blue.springbootmodular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public IPage<Account> selectAccountPage(Page<Account> page) {
        return accountMapper.selectPageVo(page);
    }
}




