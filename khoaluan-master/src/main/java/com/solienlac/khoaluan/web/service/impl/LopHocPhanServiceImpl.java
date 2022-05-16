package com.solienlac.khoaluan.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.solienlac.khoaluan.web.common.dto.LopHocPhanOfSinhVienDto;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.SinhVienLopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.LopHocPhanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Validated
public class LopHocPhanServiceImpl implements LopHocPhanService {

    private final SinhVienLopHocPhanRepository sinhVienLopHocPhanRepository;
    private final SinhVienRepository sinhVienRepository;


    @Override
    public List<LopHocPhanOfSinhVienDto> getLopHocPhanOfSinhVien( Integer idSinhVien) {
        SinhVien sinhVien = sinhVienRepository.findById(idSinhVien)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
        return sinhVienLopHocPhanRepository.findSinhVien_LopHocPhanBySinhVien(sinhVien)
                .stream().map(LopHocPhanOfSinhVienDto::new).collect(Collectors.toList());
    }
}
