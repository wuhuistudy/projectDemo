package net.syntrust.service;

import net.syntrust.entity.AccountInfo;
import org.springframework.stereotype.Service;

@Service
public interface AccountInfoService {
    int insertAccount(AccountInfo accountInfo);
}
