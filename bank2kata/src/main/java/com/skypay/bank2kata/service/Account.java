package com.skypay.bank2kata.service;

import com.skypay.bank2kata.entities.Transaction;
import com.skypay.bank2kata.entities.enums.TransactionType;
import com.skypay.bank2kata.interfaces.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private final List<Transaction> transactions;
   
    public Account() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(int amount, LocalDate date) {
        validateAmount(amount);
        transactions.add(new Transaction(date, amount, TransactionType.DEPOSIT));
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        validateAmount(amount);
        transactions.add(new Transaction(date, amount, TransactionType.WITHDRAWAL));
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    @Override
    public String printStatement() {
        StringBuilder statement = new StringBuilder("Date || Amount || Balance\n");
        int runningBalance = 0;
        List<String> statementLines = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.WITHDRAWAL) {
                runningBalance -= transaction.getAmount();
                statementLines.add(transaction.format(-transaction.getAmount(), runningBalance));
            } else {
                runningBalance += transaction.getAmount();
                statementLines.add(transaction.format(transaction.getAmount(), runningBalance));
            }
        }

        // Print in reverse chronological order
        for (int i = statementLines.size() - 1; i >= 0; i--) {
            statement.append(statementLines.get(i));
            if (i > 0) {
                statement.append("\n");
            }
        }

        return statement.toString();
    }
}