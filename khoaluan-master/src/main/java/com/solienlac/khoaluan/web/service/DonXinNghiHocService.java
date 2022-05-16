package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.param.PostDiemDanh;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.XinNghiHocParam;


public interface DonXinNghiHocService {
    Integer xinNghiHoc(Integer idSinhVien,Integer idLopHocPhan,PostDonXinNghiHoc postDonXinNghiHoc);
    Integer duyetDonXinNghiHoc(Integer idGiangVien,Integer idDonXinNghiHoc);

    Integer diemDanh(Integer idSinhVien,Integer idLopHocPhan,PostDiemDanh postDiemDanh);
    Integer xinNghiHoc(XinNghiHocParam xinNghiHocParam);

}
