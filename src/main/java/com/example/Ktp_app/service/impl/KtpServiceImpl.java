package com.example.Ktp_app.service.impl;

import com.example.Ktp_app.dto.KtpDto;
import com.example.Ktp_app.entity.KtpEntity;
import com.example.Ktp_app.mapper.KtpMapper;
import com.example.Ktp_app.repository.KtpRepository;
import com.example.Ktp_app.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {
    @Autowired private KtpRepository repository;
    @Autowired private KtpMapper mapper;

    @Override
    public KtpDto save(KtpDto dto) {
        if (repository.existsByNomorKtp(dto.getNomorKtp())) throw new RuntimeException("Nomor KTP sudah ada!");
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<KtpDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public KtpDto findById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan")));
    }

    @Override
    public KtpDto update(Integer id, KtpDto dto) {
        KtpEntity existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        existing.setNamaLengkap(dto.getNamaLengkap());
        existing.setAlamat(dto.getAlamat());
        existing.setJenisKelamin(dto.getJenisKelamin());
        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}