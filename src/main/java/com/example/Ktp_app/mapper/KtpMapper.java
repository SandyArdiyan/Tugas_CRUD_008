package com.example.Ktp_app.mapper;

import com.example.Ktp_app.dto.KtpDto;
import com.example.Ktp_app.entity.KtpEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class KtpMapper {
    public KtpEntity toEntity(KtpDto dto) {
        if (dto == null) return null;
        KtpEntity entity = new KtpEntity();
        entity.setId(dto.getId());
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        if (dto.getTanggalLahir() != null) entity.setTanggalLahir(LocalDate.parse(dto.getTanggalLahir()));
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

// Tambahkan pengecekan null agar tidak Error 500
        if (entity.getTanggalLahir() != null) {
            dto.setTanggalLahir(entity.getTanggalLahir().toString());
        }

        dto.setJenisKelamin(entity.getJenisKelamin());
        return dto;
    }
}