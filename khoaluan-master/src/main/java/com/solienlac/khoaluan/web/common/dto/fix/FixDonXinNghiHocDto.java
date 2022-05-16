package com.solienlac.khoaluan.web.common.dto.fix;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixDonXinNghiHocDto {

    private Integer id;
    private Integer idSinhVien;
    private String maSinhVien;
    private String hoTen;
    private String tenLopHocPhan;
    private Date ngayNghi;
    private Date ngayTao;
    private Boolean trangThai;
    private String noiDung;
}
