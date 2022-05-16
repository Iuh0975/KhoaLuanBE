package com.solienlac.khoaluan.web.service;

import org.springframework.web.multipart.MultipartFile;

import com.solienlac.khoaluan.web.common.dto.CheckAuthResponse;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhap;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhapResponse;
import com.solienlac.khoaluan.web.common.dto.param.CheckAuthParam;
import com.solienlac.khoaluan.web.common.dto.param.DangKiParam;
import com.solienlac.khoaluan.web.common.dto.param.PutMatKhau;


public interface TaiKhoanService {

	
    TaiKhoanDangNhapResponse userLogin(TaiKhoanDangNhap taiKhoanDangNhap);
    
    
    Integer dangKi( DangKiParam taiKhoan);
    CheckAuthResponse checkAuth(CheckAuthParam checkAuthParam);
    Integer doiMatKhau(PutMatKhau putMatKhau);
    String uploadImgUrl(Integer id,MultipartFile file);
}
