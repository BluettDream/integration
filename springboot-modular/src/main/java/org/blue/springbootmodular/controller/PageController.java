package org.blue.springbootmodular.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.blue.springbootmodular.entity.Account;
import org.blue.springbootmodular.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PostMapping("/addAccount")
    public String addAccount(@RequestBody Account account){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        account.setAccountId(uuid);
        if(accountService.save(account)){
            return "success";
        }else{
            return "false";
        }
    }

    @PostMapping("/updateAccount")
    public String updateAccount(@RequestBody Account account){
        if(accountService.updateById(account)){
            return "success";
        }else{
            return "false";
        }
    }

    @DeleteMapping("/deleteAccount{accountId}")
    public String deleteAccount(@PathVariable("accountId") String id){
        if(accountService.removeById(id)){
            return "success";
        }else{
            return "false";
        }
    }

}
