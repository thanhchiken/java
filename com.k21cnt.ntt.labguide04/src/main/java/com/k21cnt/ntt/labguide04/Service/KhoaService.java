package com.k21cnt.ntt.labguide04.Service;

import com.k21cnt.ntt.labguide04.entity.Khoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaService {
    private final List<Khoa> khoaList = new ArrayList<>();

    public KhoaService() {
        // Initialize with 5 Khoa objects
        khoaList.add(new Khoa("KH", "Khoa Hoc"));
        khoaList.add(new Khoa("CN", "Cong Nghe"));
        khoaList.add(new Khoa("KT", "Kinh Te"));
        khoaList.add(new Khoa("NN", "Ngoai Ngu"));
        khoaList.add(new Khoa("SP", "Su Pham"));
    }

    // Get all Khoa
    public List<Khoa> getAllKhoa() {
        return new ArrayList<>(khoaList);
    }

    // Get Khoa by maKh
    public Optional<Khoa> getKhoaByMaKh(String maKh) {
        return khoaList.stream()
                .filter(khoa -> khoa.getMaKh().equals(maKh))
                .findFirst();
    }

    // Add new Khoa
    public void addKhoa(Khoa khoa) {
        khoaList.add(khoa);
    }

    // Update Khoa by maKh
    public boolean updateKhoa(String maKh, Khoa updatedKhoa) {
        Optional<Khoa> existingKhoa = getKhoaByMaKh(maKh);
        if (existingKhoa.isPresent()) {
            Khoa khoa = existingKhoa.get();
            khoa.setTenKh(updatedKhoa.getTenKh());
            return true;
        }
        return false;
    }

    // Delete Khoa by maKh
    public boolean deleteKhoa(String maKh) {
        return khoaList.removeIf(khoa -> khoa.getMaKh().equals(maKh));
    }
}