package com;


import com.data.devicedata.DeviceAdapter;
import com.data.devicedata.DeviceRepository;
import com.data.newAccount.Account;
import com.data.newAccount.AccountRepository;
import com.data.oldUser.User;
import com.data.oldUser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by somebody on 2016/7/18.
 */
@Service
public class ServiceRedir {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    public List<User> getUserAll() {
        List<User> list = new ArrayList<User>();
        list = userRepository.findAll();
        return list;
    }

    public void saveAccount(User user) {
        Account account = new Account();
        account.setId(null);
        account.setPhone(user.getPhone());
        account.setEmail(user.getEmail());
        account.setPassword(user.getPassword());
        account.setEmailVerified("EMAIL".equals(user.getType().toString()) ? true : false);
        account.setPhoneVerified("PHONE".equals(user.getType().toString()) ? true : false);
        account.setNickname(user.getNickname());
        account.setWxOpenId(user.getOpenId());
        account.setCreateTimestamp(user.getCreateTime().getTime());

        accountRepository.save(account);
    }

    public List<Account> getAmountAll() {
        List<Account> list = new ArrayList<Account>();
        list = accountRepository.findAll();
        return list;
    }
    public Optional<Account> getByphone(String phone){
        return accountRepository.findByPhone(phone);
    }

    public List<DeviceAdapter> getDeviceAll() {
        List<DeviceAdapter> list = new ArrayList<DeviceAdapter>();
        list = deviceRepository.findAll();
        return list;
    }

}
