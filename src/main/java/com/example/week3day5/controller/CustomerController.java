package com.example.week3day5.controller;

import com.example.week3day5.dto.ResponseApi;
import com.example.week3day5.model.Customer;
import com.example.week3day5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    Logger logger= LoggerFactory.getLogger(CustomerController.class);
private final CustomerService customerService;

@GetMapping
public ResponseEntity getCustomers()
{
    logger.info("customers are being retrieved through getCustomers() - CustomerController");
    return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomers());
}
@PostMapping
public ResponseEntity addCustomer(@RequestBody @Valid Customer customer)
{
    logger.info("a customer is added through getCustomers() - CustomerController");
    customerService.addCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Customer added",201));
}
@PostMapping("details/add/{customer_id}/{customer_details_id}")
    public ResponseEntity addCustomerDetails(@PathVariable Integer customer_id, @PathVariable Integer customer_details_id)
{
    logger.info("a customer details are being added through addCustomerDetails() - CustomerController");

    customerService.addCustomerDetails(customer_id,customer_details_id);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Customer details added to customer",201));
}
@PostMapping("bank/add/{customer_id}/{bank_id}")
public ResponseEntity addBank(@PathVariable Integer customer_id, @PathVariable Integer bank_id)
{
    logger.info("a bank is being added to customer through addBank() - CustomerController");
    customerService.addBanktoCustomer(customer_id,bank_id);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Bank added to customer",201));
}


}
