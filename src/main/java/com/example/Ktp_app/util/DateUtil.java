package com.example.Ktp_app.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    // Format standar dari input type="date" di HTML adalah yyyy-MM-dd
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Private constructor agar class ini tidak bisa di-instansiasi (best practice untuk util class)
    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    // Fungsi untuk mengubah String dari HTML menjadi LocalDate untuk Database
    public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateString, FORMATTER);
    }

    // Fungsi untuk mengubah LocalDate dari Database menjadi String untuk HTML
    public static String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(FORMATTER);
    }
}