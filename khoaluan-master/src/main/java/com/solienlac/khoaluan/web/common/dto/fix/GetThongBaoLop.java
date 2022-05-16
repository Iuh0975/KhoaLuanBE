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
public class GetThongBaoLop {

    private Integer idThongBao;
    private String tieuDe;
    private Date ngayTao;
    private String noiDung;
    private boolean hienThi;
    private boolean trangThai;
}
