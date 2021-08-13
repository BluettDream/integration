package org.blue.springbootmodular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blue.springbootmodular.entity.Account;

/**
 * @Entity org.blue.springbootmodular.entity.Account
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    IPage<Account> selectPageVo(Page<?> page);

}




