package com.solienlac.khoaluan.web.common.dto.fix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GetLopDto {
	

    private Integer id; 
    private String tenLop;
    private String chuyenNganh;
    private String khoaHoc;
    private Integer siSo;



}
