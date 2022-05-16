package com.solienlac.khoaluan.web.service.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solienlac.khoaluan.web.common.dto.param.PostDiemDanh;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.XinNghiHocParam;
import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import com.solienlac.khoaluan.web.domain.LopHocPhan;
import com.solienlac.khoaluan.web.domain.NgayNghi;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.domain.SinhVien_LopHocPhan;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocRepository;
import com.solienlac.khoaluan.web.repository.LopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.NgayNghiRepository;
import com.solienlac.khoaluan.web.repository.SinhVienLopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DonXinNghiHocServiceImpl implements DonXinNghiHocService {
    private final DonXinNghiHocRepository donXinNghiHocRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final SinhVienRepository sinhVienRepository;
    private final NgayNghiRepository ngayNghiRepository;
    private final SinhVienLopHocPhanRepository sinhVienLopHocPhanRepository;


    @Override
    public Integer xinNghiHoc(  Integer idSinhVien, Integer idLopHocPhan,PostDonXinNghiHoc postDonXinNghiHoc) {
        SinhVien sinhVien  = sinhVienRepository.findById(idSinhVien).orElseThrow(() -> new IllegalArgumentException("id not found!"));
        LopHocPhan lopHocPhan  = lopHocPhanRepository.getOne(idLopHocPhan);
        DonXinNghiHoc donXinNghiHoc =new DonXinNghiHoc(postDonXinNghiHoc.getNoiDung(), postDonXinNghiHoc.getNgayNghi(),sinhVien,lopHocPhan );
        return  donXinNghiHocRepository.save(donXinNghiHoc).getId();
    }

    @Override
    @Transactional
    public Integer duyetDonXinNghiHoc(  Integer idGiangVien,   Integer idDonXinNghiHoc) {
        DonXinNghiHoc donXinNghiHoc = donXinNghiHocRepository.findById(idDonXinNghiHoc)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
        donXinNghiHoc.duyetDonNghiHoc();
        SinhVien_LopHocPhan sinhVien_lopHocPhan =
                sinhVienLopHocPhanRepository.findSinhVien_LopHocPhanBySinhVienAndLopHocPhan(donXinNghiHoc.getSinhVien(),donXinNghiHoc.getLopHocPhan());

       ngayNghiRepository.save(new NgayNghi(donXinNghiHoc.getNgayNghi(),sinhVien_lopHocPhan));
        Integer nghiPhep = sinhVien_lopHocPhan.getNgayNghis().stream().filter(ngayNghi -> ngayNghi.isCoPhep()).collect(Collectors.toList()).size();
        Integer nghiKhongPhep = sinhVien_lopHocPhan.getNgayNghis().stream().filter(ngayNghi -> !ngayNghi.isCoPhep()).collect(Collectors.toList()).size();

        if (((nghiPhep/2)+nghiKhongPhep)>=3){
            sinhVien_lopHocPhan.dinhChiHoc();
        }
        return donXinNghiHoc.getId();
    }



    @Override
    @Transactional
    public Integer diemDanh( Integer idSinhVien, Integer idLopHocPhan,PostDiemDanh postDiemDanh) {
        SinhVien sinhVien = sinhVienRepository.findById(idSinhVien)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
        LopHocPhan lopHocPhan = lopHocPhanRepository.findById(idLopHocPhan)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
        SinhVien_LopHocPhan sinhVien_lopHocPhan = sinhVienLopHocPhanRepository.findSinhVien_LopHocPhanBySinhVienAndLopHocPhan(sinhVien,lopHocPhan);
        NgayNghi ngayNghi = ngayNghiRepository.save(new NgayNghi(postDiemDanh,sinhVien_lopHocPhan));
        SinhVien_LopHocPhan svlhpCheck = sinhVienLopHocPhanRepository.findSinhVien_LopHocPhanBySinhVienAndLopHocPhan(sinhVien,lopHocPhan);

        Integer soNgayNghiPhep = svlhpCheck.getNgayNghis()
                .stream().filter(ngayNghiCheck ->ngayNghiCheck.isCoPhep()).collect(Collectors.toList()).size();

        Integer soNgayNghiKhongPhep = svlhpCheck.getNgayNghis()
                .stream().filter(ngayNghiCheck ->!ngayNghiCheck.isCoPhep()).collect(Collectors.toList()).size();
        if (((soNgayNghiPhep/2)+soNgayNghiKhongPhep)>=3){
            svlhpCheck.dinhChiHoc();

        }

        return ngayNghi.getId();
    }

    @Override
    public Integer xinNghiHoc(XinNghiHocParam xinNghiHocParam) {
    	System.out.println(xinNghiHocParam.getId());
        SinhVien_LopHocPhan sinhVien_lopHocPhan = sinhVienLopHocPhanRepository.findById(xinNghiHocParam.getId())
                .orElseThrow(() -> new IllegalArgumentException("id not found SinhVien_LopHocPhan!"));

        SinhVien sinhVien = sinhVienRepository.findById(sinhVien_lopHocPhan.getSinhVien().getId())
                .orElseThrow(() -> new IllegalArgumentException("id not found SinhVien !!!"));
        LopHocPhan lopHocPhan = lopHocPhanRepository.findById(sinhVien_lopHocPhan.getLopHocPhan().getId())
                .orElseThrow(() -> new IllegalArgumentException("id not found LopHocPhan!"));
        return donXinNghiHocRepository.save(new DonXinNghiHoc(xinNghiHocParam,sinhVien,lopHocPhan)).getId();
    }

//    @Override
//    public List<DonXinNghiHocDto> getDonXinNghiHocOfSinhVien(Integer idSinhVien) {
//        return donXinNghiHocCustomRepository.listDonXinNghiHocOfSinhVien(idSinhVien)
//                .stream().map(DonXinNghiHocDto::new).collect(Collectors.toList());
//    }


}
