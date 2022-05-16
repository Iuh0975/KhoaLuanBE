package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.GetThongBaoLopHocPhanSinhVienFixDto;
import com.solienlac.khoaluan.web.common.dto.fix.GetThongBaoLopSinhVienFixDto;



@Mapper
public interface ThongBaoCustomRepository {
  
	List<GetThongBaoLopHocPhanSinhVienFixDto> listThongBaoLopHocPhan(int idSinhVien);
	List<GetThongBaoLopSinhVienFixDto> listThongBaoLop(int idSinhVien);

	
		
}
