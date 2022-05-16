package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.GetLopDto;
import com.solienlac.khoaluan.web.common.dto.fix.GetLopHocSinhVien;
import com.solienlac.khoaluan.web.common.dto.fix.GetThongBaoLop;


@Mapper
public interface LopQueryRepository {
    List<GetLopDto> getLop(int idGiangVien);
    List<GetLopHocSinhVien> getSinhVienByLopHoc(int idLop);

	List<GetThongBaoLop> getThongBaoLopById(Integer idGiangVien,Integer idLopHoc);
    
    
}
