package com.coforge.AdminService.ServiceImpl;

import com.coforge.AdminService.Entity.AccountDetails;
import com.coforge.AdminService.Repository.AccountDetailsRepository;
import com.coforge.AdminService.Services.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailsImpl implements AccountDetailsService {

    @Autowired
    AccountDetailsRepository accountRepos;
    @Override
    public AccountDetails createAccount(AccountDetails accountDetails) {
       return accountRepos.save(accountDetails);
    }

    @Override
    public Boolean deleteAccount(long accountNumber) {
        accountRepos.deleteById(accountNumber);
        return true;
    }

    @Override
    public AccountDetails updateAccountDetails(AccountDetails accountDetails) {
        return accountRepos.save(accountDetails);
    }

    @Override
    public Double checkBalance(long accountId) {
        return accountRepos.findBalanceByAccountNumber(accountId);
    }

    @Override
    public boolean setBalance(long accountId, double balance) {
        accountRepos.setOpeningBalance(accountId,balance) ;
        return true;
    }
}
