package org.blue.springbootmodular.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.blue.springbootmodular.entity.Account;
import org.blue.springbootmodular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author blue
 * @date 2021/8/12
 */
@RestController
public class PageController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{currentPage}/{size}")
    public List<Account> selectAccount(@PathVariable("currentPage") long currentPage, @PathVariable("size") long size){
        return accountService.selectAccountPage(new Page<>(currentPage,size));
    }

}
