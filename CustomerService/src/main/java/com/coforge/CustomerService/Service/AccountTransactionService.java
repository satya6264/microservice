package com.coforge.CustomerService.Service;

import com.coforge.CustomerService.Entity.CustomerAccountTransaction;

import java.util.List;
import java.util.Optional;

public interface AccountTransactionService {

    CustomerAccountTransaction makeTransaction(CustomerAccountTransaction transaction);

    Optional<CustomerAccountTransaction> getTransactionById(long transactionId);

    List<CustomerAccountTransaction> getTransactionByType(String type);

    List<CustomerAccountTransaction> getTransactionByTypeAndAccountNumber(String type, long accountNumber);

}
