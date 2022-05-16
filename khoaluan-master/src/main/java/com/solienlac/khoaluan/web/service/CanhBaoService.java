package com.solienlac.khoaluan.web.service;

import java.util.List;

import com.solienlac.khoaluan.web.common.dto.CanhBaoDto;

public interface CanhBaoService {
    List<CanhBaoDto> listCanhBao(Integer idSinhVien,Integer idGiangVien);
}
