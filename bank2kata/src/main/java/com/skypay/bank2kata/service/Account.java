package com.skypay.bank2kata.service;
import com.skypay.bank2kata.interfaces.AccountService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService  {
    @Override
    public void deposit(int amount, LocalDate date) {
        throw new UnsupportedOperationException("Deposit not implemented");
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        throw new UnsupportedOperationException("Withdraw not implemented");
    }

    @Override
    public String printStatement() {
        throw new UnsupportedOperationException("Print statement not implemented");
    }
  
}
