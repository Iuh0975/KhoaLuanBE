package com.solienlac.khoaluan.web.service;

import java.util.List;

import com.solienlac.khoaluan.web.common.dto.LopHocPhanOfSinhVienDto;

public interface LopHocPhanService {

    List<LopHocPhanOfSinhVienDto> getLopHocPhanOfSinhVien(Integer idSinhVien);
}
