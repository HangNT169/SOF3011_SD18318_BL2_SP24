package com.sof3011.hangnt169.B4_CRUDListFixCung.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // contructor full ts
@NoArgsConstructor // contructor k tham so
@Builder // Tao contructor tuy y
//@Data // cam => nang
public class SinhVien {

    private String mssv;

    private String ten;

    private int tuoi;

    private boolean gioiTinh;

    private String diaChi;

}
