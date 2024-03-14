package com.sof3011.hangnt169.B4_CRUDListFixCung.service;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // fake du lieu => 5
        listSinhVien.add(new SinhVien("123", "Hang", 17, true, "HN"));
        listSinhVien.add(new SinhVien("1234", "Hgfdsang", 17, false, "HgfsdN"));
        listSinhVien.add(new SinhVien("1236", "Hagsfdng", 137, true, "HfgsdN"));
        listSinhVien.add(new SinhVien("1237", "Hsfgang", 173, false, "HgsfN"));
        listSinhVien.add(new SinhVien("1238", "Hang", 137, true, "HgfN"));
        listSinhVien.add(new SinhVien("1239", "Hang", 127, true, "HfgsdN"));
    }

    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    public void xoaSinhVien(int index) {
        listSinhVien.remove(index);
    }

    public SinhVien detailSinhVien(int index) {
        return listSinhVien.get(index);
    }

}
