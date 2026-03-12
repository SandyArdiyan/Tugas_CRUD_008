package com.example.Ktp_app.service;

import com.example.Ktp_app.dto.KtpDto;
import java.util.List;

public interface KtpService {
    KtpDto save(KtpDto dto);
    List<KtpDto> findAll();
    KtpDto findById(Integer id);
    KtpDto update(Integer id, KtpDto dto);
    void delete(Integer id);
}