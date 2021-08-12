package org.blue.springbootmodular.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.blue.springbootmodular.entity.Account;

import java.util.List;

/**
 *
 */
public interface AccountService extends IService<Account> {

    List<Account> selectAccountPage(IPage<Account> page);

}
