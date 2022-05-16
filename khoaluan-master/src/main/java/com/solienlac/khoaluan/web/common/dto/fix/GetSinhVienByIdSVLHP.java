package com.solienlac.khoaluan.web.common.dto.fix;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetSinhVienByIdSVLHP {

    private Integer idSvLhp;
    private Integer id;
    private String maSinhVien;
    private String email;
    private String hoTen;
    private DiemSinhVienMonHocDtoFix diemSinhVienMonHocDtoFix;
    private Integer soNgayNghiPhep;
    private Integer soNgayNghiKhongPhep;
    private boolean trangThai;
}
