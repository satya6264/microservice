package com.coforge.AdminService.ServiceImpl;

import com.coforge.AdminService.Entity.Customer;
import com.coforge.AdminService.Repository.CustomerRepository;
import com.coforge.AdminService.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(long id) {
        customerRepository.deleteById(id);
        return true;

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
