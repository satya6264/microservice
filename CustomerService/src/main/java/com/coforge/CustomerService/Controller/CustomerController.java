package com.coforge.CustomerService.Controller;

import com.coforge.CustomerService.Entity.CustomerAccountTransaction;
import com.coforge.CustomerService.ServiceImpl.AccountTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    AccountTransactionServiceImpl  transactionService;


    @GetMapping("/test")
    String test(){
        return "Customer Service running...";
    }

    @PostMapping("/make-transaction")
    public HashMap<String, CustomerAccountTransaction> makeTransaction(@RequestBody CustomerAccountTransaction transaction){
        HashMap<String, CustomerAccountTransaction> hm=new HashMap<>();
        CustomerAccountTransaction result= transactionService.makeTransaction(transaction);
       hm.put("response",result);
       return  hm;
    }

    @GetMapping ("/all-transaction/{transactionType}")
    public List<CustomerAccountTransaction> allTransaction(@PathVariable(name = "transactionType") String transactionType){
        return  transactionService.getTransactionByType(transactionType);
    }

    @GetMapping ("/all-transaction/{accountNumber}/{transactionType}")
    public List<CustomerAccountTransaction> allTransactionOfAccount(@PathVariable(name = "transactionType") String transactionType,@PathVariable(name = "accountNumber") long accountNumber){
        return  transactionService.getTransactionByTypeAndAccountNumber(transactionType,accountNumber);
    }


}
