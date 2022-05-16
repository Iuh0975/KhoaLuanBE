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
public class GetCanhBaoDto {

	
		private int id;
		private int idSinhVien;
		private String hoTen;
		private String noiDung;
		private String tieuDe;
		private Date ngayTao;
		private Boolean trangThai;
}
