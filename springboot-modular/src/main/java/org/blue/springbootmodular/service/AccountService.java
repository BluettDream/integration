package org.blue.springbootmodular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.blue.springbootmodular.entity.Account;

/**
 *
 */
public interface AccountService extends IService<Account> {

    IPage<Account> selectAccountPage(Page<Account> page);
}
