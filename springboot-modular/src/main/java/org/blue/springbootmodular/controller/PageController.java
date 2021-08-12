package org.blue.springbootmodular.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.blue.springbootmodular.entity.Account;
import org.blue.springbootmodular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blue
 * @date 2021/8/12
 */
@RestController
@Log4j2
public class PageController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accountPage/{currentPage}/{size}")
    public IPage<Account> selectAccountPage(@PathVariable("currentPage") long currentPage, @PathVariable("size") long size){
        return accountService.selectAccountPage(new Page<>(currentPage,size));
    }

}
