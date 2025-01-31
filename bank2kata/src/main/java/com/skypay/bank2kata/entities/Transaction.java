package com.skypay.bank2kata.entities;

import java.time.LocalDate;
import com.skypay.bank2kata.entities.enums.TransactionType;
import com.skypay.bank2kata.utils.Utils;

public final class Transaction {
    private final LocalDate date;
    private final int amount;
    private final TransactionType type;

    public Transaction(LocalDate date, int amount, TransactionType type) {
        validateDate(date);
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public TransactionType getType() {
        return type;
    }

    private void validateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot process future dated transactions");
        }
    }

    public String format(int displayAmount, int balance) {
        return String.format("%s || %d || %d",
                Utils.formatDate(this.getDate()),
                displayAmount,
                balance);
    }
}