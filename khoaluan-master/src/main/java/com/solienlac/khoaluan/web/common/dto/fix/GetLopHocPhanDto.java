package com.solienlac.khoaluan.web.common.dto.fix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetLopHocPhanDto {

    private Integer id;
    private String tenLopHocPhan;
    private Integer idMonHoc;
    private String tenMonHoc;
    private Integer siSo;
    private String chuyenNganh;
    private String thu;
    private String hocKi;
}
