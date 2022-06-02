package com.example.week3day5.controller;

import com.example.week3day5.dto.ResponseApi;
import com.example.week3day5.model.CustomerDetails;
import com.example.week3day5.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/customerdetails")
@RequiredArgsConstructor
public class CustomerDetailsController {
    Logger logger= LoggerFactory.getLogger(CustomerDetailsController.class);
    private final CustomerDetailsService customerDetailsService;
    @GetMapping
    public ResponseEntity getCustomersDetails()
    {
        logger.info("Customer details are being retrieved through getCustomerDetails()  - CustomerDetailsController");
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsService.getCustomersDetails());
    }
    @PostMapping
    public ResponseEntity addCustomerDetails(@RequestBody @Valid CustomerDetails customerDetails)
    {
        logger.info("Customer details are added through addCustomerDetails()  - CustomerDetailsController");
        customerDetailsService.addCustomerDetails(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Customer details added",201));
    }
    @PutMapping("withdraw/{customer_id}/{amount}")
    public ResponseEntity withdraw(@PathVariable Integer customer_id,@PathVariable Integer amount){
        logger.info("withdraw is being done through withdraw - CustomerDetailsController");
        customerDetailsService.withdaraw(customer_id,amount);
        return ResponseEntity.status(201).body(new ResponseApi("Amount withdrawn",201));
    }
    @PutMapping("deposit/{customer_id}/{amount}")
    public ResponseEntity deposit(@PathVariable Integer customer_id,@PathVariable Integer amount){
        logger.info("deposit is being done through withdraw - CustomerDetailsController");
        customerDetailsService.deposit(customer_id,amount);
        return ResponseEntity.status(201).body(new ResponseApi("Amount deposited",201));
    }

}
