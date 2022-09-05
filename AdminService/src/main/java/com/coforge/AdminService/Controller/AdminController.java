package com.coforge.AdminService.Controller;

import com.coforge.AdminService.DTO.CustomerAccountTransaction;
import com.coforge.AdminService.Entity.AccountDetails;
import com.coforge.AdminService.Entity.BranchDetails;
import com.coforge.AdminService.Entity.Customer;
import com.coforge.AdminService.FeignClientService.CustomerService;
import com.coforge.AdminService.ServiceImpl.AccountDetailsImpl;
import com.coforge.AdminService.ServiceImpl.BranchServiceImpl;
import com.coforge.AdminService.ServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class AdminController {

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    BranchServiceImpl branchService;

    @Autowired
    AccountDetailsImpl accountService;

    @Autowired
    CustomerService customerServiceFeignClient;

    @PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomerDetails(@RequestBody Customer customer){
            Customer result=customerService.saveCustomer(customer);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/delete-customer/{customerId}")
    public ResponseEntity<Boolean> deleteCustomerDetails(@PathVariable (name="customerId") int customerId){
        Boolean result=customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update-customer/{customerId}")
    public ResponseEntity<Customer> updateCustomerDetails(@PathVariable(name="customerId") int customerId, @RequestBody Customer customer){
        customer.setCustomerNumber(customerId);
        Customer result=customerService.updateCustomer(customer);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }



    @PostMapping("/create-account")
    public ResponseEntity<AccountDetails> createBankAccount(@RequestBody AccountDetails accountDetails){
        AccountDetails result=accountService.createAccount(accountDetails);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/delete-account/{accountNumber}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable (name="accountNumber") long accountNumber){
        Boolean result=accountService.deleteAccount(accountNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update-account/{accountNumber}")
    public ResponseEntity<AccountDetails> updateAccountNumber(@PathVariable (name="accountNumber") long accountNumber,@RequestBody AccountDetails accountDetails){
        accountDetails.setAccountNumber(accountNumber);
        AccountDetails result=accountService.updateAccountDetails(accountDetails);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/create-branch")
    public ResponseEntity<BranchDetails> createBranch(@RequestBody BranchDetails branch){
        BranchDetails result=branchService.saveBranch(branch);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @GetMapping("/delete-branch/{branchId}")
    public ResponseEntity<Boolean> deleteBranch(@PathVariable (name="branchId") int branchId){
        Boolean result=branchService.deleteBranch(branchId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update-branch/{branchId}")
    public ResponseEntity<BranchDetails> updateBranchDetails(@PathVariable (name="branchId") int branchId,@RequestBody BranchDetails branchDetails){
        branchDetails.setBranchId(branchId);
        BranchDetails result=branchService.updateBranch(branchDetails);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/check-balance/{accountNumber}")
    public HashMap<String,Double> checkBalance(@PathVariable (name="accountNumber") long accountNumber){
        Double result=accountService.checkBalance(accountNumber);
        HashMap<String,Double> rt=new HashMap<>();
        rt.put("balance", result);
        return rt;
    }

    @PutMapping("/set-balance/{accountNumber}")
    public ResponseEntity<Boolean> setAccountBalance(@PathVariable (name="accountNumber") long accountNumber, @RequestBody AccountDetails account){
        Boolean result=accountService.setBalance(accountNumber,account.getOpeningBalance());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all-transactions/{accountNumber}/{transactionType}")
    public List<CustomerAccountTransaction> getTransaction(@PathVariable (name="accountNumber") long accountNumber, @PathVariable (name="transactionType") String transactionType){
        List<CustomerAccountTransaction> result=customerServiceFeignClient.allTransactionOfAccount(transactionType,accountNumber);
        return result;
    }

}
