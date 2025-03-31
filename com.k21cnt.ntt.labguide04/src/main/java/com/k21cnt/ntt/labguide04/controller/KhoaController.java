package com.k21cnt.ntt.labguide04.controller;

import com.k21cnt.ntt.labguide04.dto.KhoaDTO;
import com.k21cnt.ntt.labguide04.entity.Khoa;
import com.k21cnt.ntt.labguide04.Service.KhoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public List<Khoa> getAllKhoa() {
        return khoaService.getAllKhoa();
    }

    @GetMapping("/{maKh}")
    public ResponseEntity<Khoa> getKhoaByMaKh(@PathVariable String maKh) {
        Optional<Khoa> khoa = khoaService.getKhoaByMaKh(maKh);
        return khoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Khoa> addKhoa(@Valid @RequestBody KhoaDTO khoaDTO) {
        Khoa khoa = new Khoa(khoaDTO.getMaKh(), khoaDTO.getTenKh());
        khoaService.addKhoa(khoa);
        return ResponseEntity.ok(khoa);
    }

    @PutMapping("/{maKh}")
    public ResponseEntity<String> updateKhoa(@PathVariable String maKh, @Valid @RequestBody KhoaDTO khoaDTO) {
        Khoa updatedKhoa = new Khoa(khoaDTO.getMaKh(), khoaDTO.getTenKh());
        boolean updated = khoaService.updateKhoa(maKh, updatedKhoa);
        if (updated) {
            return ResponseEntity.ok("Cập nhật khoa thành công");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{maKh}")
    public ResponseEntity<String> deleteKhoa(@PathVariable String maKh) {
        boolean deleted = khoaService.deleteKhoa(maKh);
        if (deleted) {
            return ResponseEntity.ok("Xóa khoa thành công");
        }
        return ResponseEntity.notFound().build();
    }
}