package com.k21cnt.ntt.labguide04.Service;

import com.k21cnt.ntt.labguide04.entity.MonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonHocService {
    private final List<MonHoc> monHocList = new ArrayList<>();

    public MonHocService() {
        // Initialize with 5 MonHoc objects
        monHocList.add(new MonHoc("TH", "Tin Hoc", 45));
        monHocList.add(new MonHoc("TO", "Toan Hoc", 60));
        monHocList.add(new MonHoc("LY", "Vat Ly", 50));
        monHocList.add(new MonHoc("HO", "Hoa Hoc", 55));
        monHocList.add(new MonHoc("SI", "Sinh Hoc", 48));
    }

    public List<MonHoc> getAllMonHoc() {
        return new ArrayList<>(monHocList);
    }

    public Optional<MonHoc> getMonHocByMaMh(String maMh) {
        return monHocList.stream()
                .filter(monHoc -> monHoc.getMaMh().equals(maMh))
                .findFirst();
    }

    public void addMonHoc(MonHoc monHoc) {
        monHocList.add(monHoc);
    }

    public boolean updateMonHoc(String maMh, MonHoc updatedMonHoc) {
        Optional<MonHoc> existingMonHoc = getMonHocByMaMh(maMh);
        if (existingMonHoc.isPresent()) {
            MonHoc monHoc = existingMonHoc.get();
            monHoc.setTenMh(updatedMonHoc.getTenMh());
            monHoc.setSoTiet(updatedMonHoc.getSoTiet());
            return true;
        }
        return false;
    }

    public boolean deleteMonHoc(String maMh) {
        return monHocList.removeIf(monHoc -> monHoc.getMaMh().equals(maMh));
    }
}