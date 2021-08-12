package org.blue.springbootmodular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.blue.springbootmodular.entity.Account;

import java.util.List;

/**
 * @Entity org.blue.springbootmodular.entity.Account
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    List<Account> selectPage(IPage<Account> page);

}




