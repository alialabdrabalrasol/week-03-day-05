package com.example.week3day5.service;

import com.example.week3day5.exception.InvalidIDException;
import com.example.week3day5.model.Bank;
import com.example.week3day5.model.Customer;
import com.example.week3day5.model.CustomerDetails;
import com.example.week3day5.repository.BankRepository;
import com.example.week3day5.repository.CustomerDetailsRepository;
import com.example.week3day5.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    private final BankRepository bankRepository;
    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }
    public void addCustomerDetails(Integer customer_id,Integer customer_details_id)
    {
        Optional<Customer>customer=customerRepository.findById(customer_id);
        if(customer.isEmpty()){throw new InvalidIDException("Invalid user id");
        }
        Optional<CustomerDetails>customerDetails=customerDetailsRepository.findById(customer_details_id);
        if(customerDetails.isEmpty()){throw new InvalidIDException("Invalid customer id");}
        customer.get().setCustomerDetails(customerDetails.get());
        customerRepository.save(customer.get());


    }
    public void addBanktoCustomer(Integer customer_id,Integer bank_id)
    {
        Optional<Customer>customer=customerRepository.findById(customer_id);
        if(customer.isEmpty()){throw new InvalidIDException("Invalid user id");}
        Optional<Bank>bank=bankRepository.findById(bank_id);
        if(bank.isEmpty()){throw new InvalidIDException("Invalid bank id");}
        customer.get().getBanks().add(bank.get());
        customerRepository.save(customer.get());
    }

}
