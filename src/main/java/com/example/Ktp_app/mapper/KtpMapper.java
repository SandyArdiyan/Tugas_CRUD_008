package com.example.Ktp_app.mapper;

import com.example.Ktp_app.dto.KtpDto;
import com.example.Ktp_app.entity.KtpEntity;
import com.example.Ktp_app.util.DateUtil; // <-- Import DateUtil di sini
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {
    public KtpEntity toEntity(KtpDto dto) {
        if (dto == null) return null;
        KtpEntity entity = new KtpEntity();
        entity.setId(dto.getId());
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());

        // Menggunakan util
        entity.setTanggalLahir(DateUtil.parseDate(dto.getTanggalLahir()));

        entity.setJenisKelamin(dto.getJenisKelamin());
        return entity;
    }

    public KtpDto toDto(KtpEntity entity) {
        if (entity == null) return null;
        KtpDto dto = new KtpDto();
        dto.setId(entity.getId());
        dto.setNomorKtp(entity.getNomorKtp());
        dto.setNamaLengkap(entity.getNamaLengkap());
        dto.setAlamat(entity.getAlamat());

        // Menggunakan util
        dto.setTanggalLahir(DateUtil.formatDate(entity.getTanggalLahir()));

        dto.setJenisKelamin(entity.getJenisKelamin());
        return dto;
    }
}