package com.k21cnt.ntt.labguide04.controller;

import com.k21cnt.ntt.labguide04.dto.MonHocDTO;
import com.k21cnt.ntt.labguide04.entity.MonHoc;
import com.k21cnt.ntt.labguide04.Service.MonHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public List<MonHoc> getAllMonHoc() {
        return monHocService.getAllMonHoc();
    }

    @GetMapping("/{maMh}")
    public ResponseEntity<MonHoc> getMonHocByMaMh(@PathVariable String maMh) {
        Optional<MonHoc> monHoc = monHocService.getMonHocByMaMh(maMh);
        return monHoc.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MonHoc> addMonHoc(@Valid @RequestBody MonHocDTO monHocDTO) {
        MonHoc monHoc = new MonHoc(monHocDTO.getMaMh(), monHocDTO.getTenMh(), monHocDTO.getSoTiet());
        monHocService.addMonHoc(monHoc);
        return ResponseEntity.ok(monHoc);
    }

    @PutMapping("/{maMh}")
    public ResponseEntity<String> updateMonHoc(@PathVariable String maMh, @Valid @RequestBody MonHocDTO monHocDTO) {
        MonHoc updatedMonHoc = new MonHoc(monHocDTO.getMaMh(), monHocDTO.getTenMh(), monHocDTO.getSoTiet());
        boolean updated = monHocService.updateMonHoc(maMh, updatedMonHoc);
        if (updated) {
            return ResponseEntity.ok("Cập nhật môn học thành công");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{maMh}")
    public ResponseEntity<String> deleteMonHoc(@PathVariable String maMh) {
        boolean deleted = monHocService.deleteMonHoc(maMh);
        if (deleted) {
            return ResponseEntity.ok("Xóa môn học thành công");
        }
        return ResponseEntity.notFound().build();
    }
}