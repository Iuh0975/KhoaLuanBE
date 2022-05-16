package com.solienlac.khoaluan.web.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.solienlac.khoaluan.web.common.dto.NgayNghiDto;

public interface NgayNghiService {
    List<NgayNghiDto> listNgayNghiDtoOfSinhVienLhp(Integer idSinhVienLhp);
    ResponseEntity<Void> xoaNgayNghi(Integer idNgayNghi);
}
