package com.coforge.CustomerService.FeignClientService;

import com.coforge.CustomerService.DTO.AccountDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;


@FeignClient("ADMINSERVICE")
public interface AdminService {

    @GetMapping("/check-balance/{accountNumber}")
    public HashMap<String, Double> checkBalance(@PathVariable(name = "accountNumber") long accountNumber);

    @PutMapping("/set-balance/{accountNumber}")
    public ResponseEntity<Boolean> setAccountBalance(@PathVariable(name = "accountNumber") long accountNumber, @RequestBody AccountDetails account);

}

