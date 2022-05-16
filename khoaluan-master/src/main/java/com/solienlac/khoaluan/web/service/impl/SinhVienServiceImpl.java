package com.solienlac.khoaluan.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.SinhVienService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Log4j2
@Validated
public class SinhVienServiceImpl implements SinhVienService {
    private final SinhVienRepository sinhVienRepository;

    @Override
    public ThongTinSinhVienDto xemThongTin(Integer id) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));

        return new ThongTinSinhVienDto(sinhVien);
    }

    @Override
    @Transactional
    public Integer chinhSuaSinhVien(Integer id,PutSinhVienParam putSinhVienParam) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));
        sinhVien.chinhSua(putSinhVienParam);
        return id;
    }


}
