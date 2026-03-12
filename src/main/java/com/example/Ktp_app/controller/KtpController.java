package com.example.Ktp_app.controller;

import com.example.Ktp_app.dto.KtpDto;
import com.example.Ktp_app.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {
    @Autowired private KtpService service;

    @PostMapping
    public KtpDto create(@RequestBody KtpDto dto) { return service.save(dto); }

    @GetMapping
    public List<KtpDto> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public KtpDto getById(@PathVariable Integer id) { return service.findById(id); }

    @PutMapping("/{id}")
    public KtpDto update(@PathVariable Integer id, @RequestBody KtpDto dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { service.delete(id); }
}