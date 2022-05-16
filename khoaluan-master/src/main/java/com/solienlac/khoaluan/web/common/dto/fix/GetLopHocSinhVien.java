package com.solienlac.khoaluan.web.common.dto.fix;

import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetLopHocSinhVien {

	private Integer id;
	private String hoTen;
	private String maSinhVien;
	private boolean gioiTinh;
	private String email;
	private String soDienThoai;
	private TrangThaiSinhVien trangThaiSV;
	private String trangThai;
	private double diemTBTL;

}
