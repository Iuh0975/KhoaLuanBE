package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.GetLopHocPhanDto;
import com.solienlac.khoaluan.web.common.dto.fix.GetSinhVienByIdSVLHP;
import com.solienlac.khoaluan.web.common.dto.fix.GetThongBaoLop;

@Mapper
public interface LopHocPhanCustomRepository {
   
	  List<GetLopHocPhanDto> getLopHocPhan(int idGiangVien);
	  List<GetSinhVienByIdSVLHP> getSinhVienByIdLHP(int idLopHocPhan);
	  List<GetThongBaoLop> getThongBaoLopById(Integer idLopHoc,Integer idGiangVien);
}
