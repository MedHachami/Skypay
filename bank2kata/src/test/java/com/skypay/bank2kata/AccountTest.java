package com.skypay.bank2kata;

import org.junit.jupiter.api.Test;
import com.skypay.bank2kata.interfaces.AccountService;
import com.skypay.bank2kata.service.Account;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDate;

public class AccountTest {

    private AccountService account;
    
    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    @DisplayName("Should handle zero amount transactions")
    void testZeroAmountTransactions() {
        account.deposit(0, LocalDate.of(2012, 1, 10));
        account.withdraw(0, LocalDate.of(2012, 1, 11));
        String expectedStatement = 
            "Date || Amount || Balance\n" +
            "11/01/2012 || 0 || 0\n" +
            "10/01/2012 || 0 || 0";
        assertEquals(expectedStatement, account.printStatement().trim());
    }

    @Test
    @DisplayName("Should handle transactions on the same date")
    void testTransactionsOnSameDate() {
        LocalDate sameDate = LocalDate.of(2012, 1, 10);
        account.deposit(1000, sameDate);
        account.deposit(2000, sameDate);
        account.withdraw(500, sameDate);
        String expectedStatement = 
            "Date || Amount || Balance\n" +
            "10/01/2012 || -500 || 2500\n" +
            "10/01/2012 || 2000 || 3000\n" +
            "10/01/2012 || 1000 || 1000";
        assertEquals(expectedStatement, account.printStatement().trim());
    }

    @Test
    @DisplayName("Should handle negative balance after withdrawal")
    void testNegativeBalance() {
        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.withdraw(2000, LocalDate.of(2012, 1, 11));
        String expectedStatement = 
            "Date || Amount || Balance\n" +
            "11/01/2012 || -2000 || -1000\n" +
            "10/01/2012 || 1000 || 1000";
        assertEquals(expectedStatement, account.printStatement().trim());
    }

    @Test
    @DisplayName("Should throw exception for null date")
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(1000, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1000, null);
        });
    }

    @Test
    @DisplayName("Should throw exception for future date")
    void testFutureDate() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(1000, futureDate);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1000, futureDate);
        });
    }

    @Test
    @DisplayName("Should throw exception for negative amount")
    void testNegativeAmount() {
        LocalDate validDate = LocalDate.now();
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-1000, validDate);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-1000, validDate);
        });
    }
}