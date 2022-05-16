package com.solienlac.khoaluan.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.solienlac.khoaluan.web.common.dto.CheckAuthResponse;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhap;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhapResponse;
import com.solienlac.khoaluan.web.common.dto.param.CheckAuthParam;
import com.solienlac.khoaluan.web.common.dto.param.DangKiParam;
import com.solienlac.khoaluan.web.common.dto.param.PutMatKhau;
import com.solienlac.khoaluan.web.service.TaiKhoanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/taikhoan")
public class TaiKhoanApiController {
    private final TaiKhoanService taiKhoanService;

    @PostMapping("/dangnhap")
    public  ResponseEntity<TaiKhoanDangNhapResponse> dangNhap(@RequestBody TaiKhoanDangNhap taiKhoanDangNhap){
        TaiKhoanDangNhapResponse userLoginResponseDto = taiKhoanService.userLogin(taiKhoanDangNhap);
        return ResponseEntity.ok(userLoginResponseDto);
    }

    @PostMapping("/dangki")
    @ResponseStatus(HttpStatus.CREATED)
    public int dangKi(@RequestBody DangKiParam thongTin){
        return taiKhoanService.dangKi(thongTin);
    }

    @PostMapping("/checkauth")
    @ResponseStatus(HttpStatus.OK)
    public CheckAuthResponse checkAuthencation(@RequestBody CheckAuthParam checkAuthParam){
        return taiKhoanService.checkAuth(checkAuthParam);
    }

    @PutMapping("/doimatkhau")
    @ResponseStatus(HttpStatus.OK)
    public Integer doiMatKhau(@RequestBody PutMatKhau putMatKhau){
        return taiKhoanService.doiMatKhau(putMatKhau);
    }


    @PutMapping("/avatar/{id}")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,@PathVariable("id")Integer id) {
        System.out.println(file.getOriginalFilename());;
        return taiKhoanService.uploadImgUrl(id, file);
    }
    

}
