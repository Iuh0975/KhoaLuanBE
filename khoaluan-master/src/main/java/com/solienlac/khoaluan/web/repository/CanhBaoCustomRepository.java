package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.GetCanhBaoDto;
import com.solienlac.khoaluan.web.common.dto.fix.ThoiHocDto;
import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;

@Mapper
public interface CanhBaoCustomRepository {
    List<GetCanhBaoDto> listCanhBaoSinhVien(Integer id,Integer idGiangVien);
    
    ThoiHocDto checkSoLanCanhBao(int id);
    
    void updateTrangThaiThoiHoc(TrangThaiSinhVien trangThai, int id);
}
