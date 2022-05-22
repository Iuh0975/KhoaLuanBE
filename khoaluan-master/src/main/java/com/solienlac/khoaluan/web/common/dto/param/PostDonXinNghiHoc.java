package com.solienlac.khoaluan.web.common.dto.param;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDonXinNghiHoc {

    private String noiDung;


    private Date ngayNghi;
}
