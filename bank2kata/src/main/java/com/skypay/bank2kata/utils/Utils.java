package com.skypay.bank2kata.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public final class Utils {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Utils() {
    }

    public static String formatDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.format(DATE_FORMATTER);
    }
}