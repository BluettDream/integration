package org.blue.springbootmodular.service.impl;

import org.blue.springbootmodular.entity.Account;
import org.blue.springbootmodular.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/**
 * @author blue
 * @date 2021/8/12
 */
@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testConnect(){
        List<Account> accountList = accountService.list();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    void testSave(){
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString().replace("-","").toLowerCase());
        account.setAccountName("王五");
        account.setAccountAge(20);
        account.setAccountSex("男");
        account.setAccountAddress("上海市嘉定区");
        accountService.save(account);
    }
}