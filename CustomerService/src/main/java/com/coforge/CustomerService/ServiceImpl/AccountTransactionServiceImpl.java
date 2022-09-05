package com.coforge.CustomerService.ServiceImpl;

import com.coforge.CustomerService.DTO.AccountDetails;
import com.coforge.CustomerService.Entity.CustomerAccountTransaction;
import com.coforge.CustomerService.FeignClientService.AdminService;
import com.coforge.CustomerService.Repository.CustomerAccountTransactionRepository;
import com.coforge.CustomerService.Service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    CustomerAccountTransactionRepository transactionRepository;

    @Autowired
    AdminService adminService;

    @Override
    public CustomerAccountTransaction makeTransaction(CustomerAccountTransaction transaction) {
        CustomerAccountTransaction result=null;
        HashMap<String,Double> hmr=adminService.checkBalance(transaction.getAccountNumber());
        if(hmr.containsKey("balance")){
            double balance=hmr.get("balance");
            if(transaction.getTransactionType().equals("C")){
                balance=balance+transaction.getTransactionAmount();
                adminService.setAccountBalance(transaction.getAccountNumber(), new AccountDetails(balance));
                result=transactionRepository.save(transaction);
            }else if(transaction.getTransactionType().equals("D")){
                if(balance>=transaction.getTransactionAmount()){
                    balance=balance-transaction.getTransactionAmount();
                    adminService.setAccountBalance(transaction.getAccountNumber(), new AccountDetails(balance));
                    result=transactionRepository.save(transaction);
                }
            }
        }
        return result;

    }

    @Override
    public Optional<CustomerAccountTransaction> getTransactionById(long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public List<CustomerAccountTransaction> getTransactionByType(String type) {
        return transactionRepository.findAllByTransactionType(type);
    }

    @Override
    public List<CustomerAccountTransaction> getTransactionByTypeAndAccountNumber(String type, long accountNumber) {
        List<CustomerAccountTransaction> list=new ArrayList<>();
        if(type.equalsIgnoreCase("ALL")){
             list=transactionRepository.findAllByAccountNumber(accountNumber);
        }else{
            list= transactionRepository.findAllByTransactionTypeAndAccountNumber(type,accountNumber);
        }
        return list;
    }


}
