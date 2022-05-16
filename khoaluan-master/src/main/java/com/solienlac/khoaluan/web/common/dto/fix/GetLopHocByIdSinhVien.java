package com.solienlac.khoaluan.web.common.dto.fix;

import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetLopHocByIdSinhVien {

    private Integer id;
    private String hoTen;
    private String maSinhVien;
    private boolean gioiTinh;
    private String email;
    private String soDienThoai;
    private TrangThaiSinhVien trangThaiSV;
    private boolean trangThai;
    private double diemTBTL;
    
	public GetLopHocByIdSinhVien(GetLopHocSinhVien sv) {
		this.id = sv.getId();
		this.hoTen = sv.getHoTen();
		this.maSinhVien = sv.getMaSinhVien();
		this.gioiTinh = sv.isGioiTinh();
		this.email = sv.getEmail();
		this.soDienThoai = sv.getSoDienThoai();
		this.trangThaiSV = sv.getTrangThaiSV();
		this.trangThai = sv.getTrangThai() != null ? true:false;
		this.diemTBTL = sv.getDiemTBTL();
	}
    
    
    
}
