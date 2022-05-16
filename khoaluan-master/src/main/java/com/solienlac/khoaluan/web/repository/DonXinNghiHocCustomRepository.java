package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.FixDonXinNghiHocDto;
import com.solienlac.khoaluan.web.common.dto.fix.GetDonXinNghiHocByIdSV;

@Mapper
public interface DonXinNghiHocCustomRepository {

		List<FixDonXinNghiHocDto> getListDonXinHocByIdGiangVien(int idLopHocPhan, int idGiangVien);
		List<GetDonXinNghiHocByIdSV> getListDonXinHocByIdSinhVien(int idSinhVien);
	
		
}
