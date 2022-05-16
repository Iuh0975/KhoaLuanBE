package com.solienlac.khoaluan.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.solienlac.khoaluan.web.common.dto.fix.GetCanhBaoDto;

@Mapper
public interface CanhBaoCustomRepository {
    List<GetCanhBaoDto> listCanhBaoSinhVien(Integer id,Integer idGiangVien);
}
