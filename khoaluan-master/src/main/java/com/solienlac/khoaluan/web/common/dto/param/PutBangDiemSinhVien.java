package com.solienlac.khoaluan.web.common.dto.param;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PutBangDiemSinhVien {
    private double tk1;
    private double tk2;
    private double tk3;
    private double gk;
    private double ck;
}
