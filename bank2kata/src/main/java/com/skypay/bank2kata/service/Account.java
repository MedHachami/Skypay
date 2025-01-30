package com.skypay.bank2kata.service;

import com.skypay.bank2kata.interfaces.AccountService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount, LocalDate date) {
        validateTransaction(amount, date);
        transactions.add(new Transaction(date, amount));
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        validateTransaction(amount, date);
        transactions.add(new Transaction(date, -amount));
    }

    @Override
    public String printStatement() {
        StringBuilder statement = new StringBuilder("Date || Amount || Balance\n");
        int runningBalance = 0;
        List<String> statementLines = new ArrayList<>();

        for (Transaction transaction : transactions) {
            runningBalance += transaction.amount;
            statementLines.add(formatTransaction(transaction, runningBalance));
        }

        for (int i = statementLines.size() - 1; i >= 0; i--) {
            statement.append(statementLines.get(i)).append("\n");
        }

        return statement.toString().trim();
    }

    private void validateTransaction(int amount, LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot process future dated transactions");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    private String formatTransaction(Transaction transaction, int balance) {
        return String.format("%s || %d || %d",
                formatDate(transaction.date),
                transaction.amount,
                balance);
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static class Transaction {
        private final LocalDate date;
        private final int amount;

        Transaction(LocalDate date, int amount) {
            this.date = date;
            this.amount = amount;
        }
    }
}