package com.example.week3day5.controller;

import com.example.week3day5.dto.ResponseApi;
import com.example.week3day5.model.Bank;
import com.example.week3day5.service.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {
    Logger logger= LoggerFactory.getLogger(BankController.class);
    private final BankService bankService;
    @GetMapping
    public ResponseEntity getBanks()
    {
        logger.info("banks are being retrieved through getBanks - BankController");
        return ResponseEntity.status(HttpStatus.OK).body(bankService.getBanks());
    }
    @PostMapping
    public ResponseEntity addBank(@RequestBody @Valid Bank bank)
    {
        logger.info("a bank is being added through getBanks - BankController");
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Bank added",201));
    }
}
