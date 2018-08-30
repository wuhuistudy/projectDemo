package net.syntrust.service.impl;

import net.syntrust.dao.AccountInfoDao;
import net.syntrust.entity.AccountInfo;
import net.syntrust.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountInfoService")
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    public AccountInfoDao accountInfoDao;
    @Override
    public int insertAccount(AccountInfo accountInfo) {
        return accountInfoDao.insertAccount(accountInfo);
    }
}
