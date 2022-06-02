package com.example.week3day5.service;

import com.example.week3day5.model.Bank;
import com.example.week3day5.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;
    public List<Bank> getBanks()
    {
        return bankRepository.findAll();
    }
    public void addBank(Bank bank)
    {
        bankRepository.save(bank);
    }
}
