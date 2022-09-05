package com.coforge.AdminService.Services;

import com.coforge.AdminService.Entity.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);
    public boolean deleteCustomer(long id);
    public Customer updateCustomer(Customer customer);

}
