package com.example.Ktp_app.dto;

import lombok.Data;

@Data
public class KtpDto {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private String tanggalLahir; // String untuk mempermudah parsing dari HTML
    private String jenisKelamin;
}