package com.skypay.bank2kata.interfaces;

import java.time.LocalDate;

public interface AccountService {
    public void deposit(int amount, LocalDate date) ;
    public void withdraw(int amount, LocalDate date);
    public String printStatement();
}
