package com.solienlac.khoaluan.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solienlac.khoaluan.web.common.dto.param.PostThongBaoLop;
import com.solienlac.khoaluan.web.domain.GiangVien;
import com.solienlac.khoaluan.web.domain.Lop;
import com.solienlac.khoaluan.web.domain.LopHocPhan;
import com.solienlac.khoaluan.web.domain.ThongBao;
import com.solienlac.khoaluan.web.domain.ThongBao_Lop;
import com.solienlac.khoaluan.web.domain.ThongBao_LopHocPhan;
import com.solienlac.khoaluan.web.repository.GiangVienRepository;
import com.solienlac.khoaluan.web.repository.LopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.LopRepository;
import com.solienlac.khoaluan.web.repository.ThongBaoLopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.ThongBaoLopRepository;
import com.solienlac.khoaluan.web.repository.ThongBaoRepository;
import com.solienlac.khoaluan.web.service.ThongBaoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThongBaoServiceImpl implements ThongBaoService {


    private final LopRepository lopRepository;
    private final GiangVienRepository giangVienRepository;
    private final ThongBaoRepository thongBaoRepository;
    private final ThongBaoLopRepository thongBaoLopRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final ThongBaoLopHocPhanRepository thongBaoLopHocPhanRepository;
    


    @Override
    public Integer themThongBaoLop(Integer idGiangVien,Integer idLop,PostThongBaoLop postThongBaoLop) {
        Lop lop = lopRepository.findById(idLop).orElseThrow(() -> new IllegalArgumentException("id not found"));
        GiangVien giangVien = giangVienRepository.findById(idGiangVien).orElseThrow(() -> new IllegalArgumentException("id not found"));
        ThongBao thongBao =new ThongBao(postThongBaoLop,giangVien);
        ThongBao thongBaoResult = thongBaoRepository.save(thongBao);
        thongBaoLopRepository.save(new ThongBao_Lop(thongBaoResult,lop));
        return thongBaoResult.getId();
    }

    @Override
    public Integer themThongBaoLopHocPhan(Integer idGiangVien,Integer idLopHocPhan,PostThongBaoLop postThongBaoLop) {
        LopHocPhan lopHocPhan = lopHocPhanRepository.findById(idLopHocPhan).orElseThrow(() -> new IllegalArgumentException("id not found"));
        GiangVien giangVien = giangVienRepository.findById(idGiangVien).orElseThrow(() -> new IllegalArgumentException("id not found"));
        ThongBao thongBao =new ThongBao(postThongBaoLop,giangVien);
        ThongBao thongBaoResult = thongBaoRepository.save(thongBao);
        thongBaoLopHocPhanRepository.save(new ThongBao_LopHocPhan(thongBaoResult,lopHocPhan));
        return thongBaoResult.getId();
    }

    @Override
    @Transactional
    public Integer chinhSuaThongBaoLop(Integer idThongBao,PostThongBaoLop postThongBaoLop) {
        ThongBao thongBao = thongBaoRepository.findById(idThongBao).orElseThrow(() -> new IllegalArgumentException("id not found"));
        thongBao.chinhSuaThongBaoLop(postThongBaoLop);
        return thongBao.getId();
    }


    @Override
    @Transactional
    public Integer chinhSuaHienThiThongBaoLop(Integer idThongBao) {
        ThongBao thongBao = thongBaoRepository.findById(idThongBao).orElseThrow(() -> new IllegalArgumentException("id not found"));
        thongBao.chinhSuaHienThiThongBaoLop();
        return thongBao.getId();
    }
}
