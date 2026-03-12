package com.example.Ktp_app.repository;

import com.example.Ktp_app.entity.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
}