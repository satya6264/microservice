package com.coforge.AdminService.Services;

import com.coforge.AdminService.Entity.AccountDetails;

public interface AccountDetailsService {

    AccountDetails createAccount(AccountDetails accountDetails);
    Boolean deleteAccount(long accountNumber);
    AccountDetails updateAccountDetails(AccountDetails accountDetails);

    Double checkBalance(long accountId);

    boolean setBalance(long accountId, double balance);

}
