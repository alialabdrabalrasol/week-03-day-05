package com.example.week3day5.service;

import com.example.week3day5.exception.InvalidIDException;
import com.example.week3day5.exception.NoFundsException;
import com.example.week3day5.model.CustomerDetails;
import com.example.week3day5.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService{
    private final CustomerDetailsRepository customerDetailsRepository;
    public List<CustomerDetails> getCustomersDetails()
    {
        return customerDetailsRepository.findAll();
    }
    public void addCustomerDetails(CustomerDetails customerDetails)
    {
        customerDetailsRepository.save(customerDetails);
    }
    public void withdaraw(Integer customer_id,Integer amount){
        Optional<CustomerDetails>customerDetails=customerDetailsRepository.findById(customer_id);
        if(customerDetails.isEmpty()){
            throw new InvalidIDException("Customer not found");
        }
        if(customerDetails.get().getBalance()<amount){
            throw new NoFundsException("No enough founds");
        }
    customerDetails.get().setBalance(customerDetails.get().getBalance()-amount);
    customerDetailsRepository.save(customerDetails.get());
    }
    public void deposit(Integer customer_id,Integer amount){
        Optional<CustomerDetails>customerDetails=customerDetailsRepository.findById(customer_id);
        if(customerDetails.isEmpty()){
            throw new InvalidIDException("Customer not found");
        }

        customerDetails.get().setBalance(customerDetails.get().getBalance()+amount);
        customerDetailsRepository.save(customerDetails.get());
    }
}
