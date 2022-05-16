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
public class GetThongBaoLopHocPhanSinhVienFixDto {

    private Integer id;
    private String tieuDe;
    private final String thongBaoType = "TB_LOPHOCPHAN";
    private String noiDung;
    private Date ngayTao;
    private String hoTen;
    
    
    
    
    
}
