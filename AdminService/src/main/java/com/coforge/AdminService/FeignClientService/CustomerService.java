package com.coforge.AdminService.FeignClientService;

import com.coforge.AdminService.DTO.CustomerAccountTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CUSTOMERSERVICE")
public interface CustomerService {

    @GetMapping ("/all-transaction/{accountNumber}/{transactionType}")
    public List<CustomerAccountTransaction> allTransactionOfAccount(@PathVariable(name = "transactionType") String transactionType,@PathVariable(name = "accountNumber") long accountNumber);
}
