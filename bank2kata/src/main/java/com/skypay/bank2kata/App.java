package com.skypay.bank2kata;
import java.time.LocalDate;

import com.skypay.bank2kata.interfaces.AccountService;
import com.skypay.bank2kata.service.Account;


public class App 
{
    public static void main( String[] args )
    {
          AccountService account = new Account();

        // Perform some transactions
        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(5000, LocalDate.of(2012, 1, 14));

        // Print the statement
        String statement = account.printStatement();
        System.out.println("Account Statement:");
        System.out.println(statement);

        // Demonstrate error handling
        try {
            account.deposit(-100, LocalDate.now());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.withdraw(1000, LocalDate.now().plusDays(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
