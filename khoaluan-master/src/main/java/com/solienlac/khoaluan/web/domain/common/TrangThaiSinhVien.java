package com.solienlac.khoaluan.web.domain.common;

public enum TrangThaiSinhVien {
	DANG_HOC("DANG_HOC"), DINH_CHI("DInh_CHI"), BAO_LUU("BAO_LUU"), THOI_HOC("THOI_HOC");

	 private final String code;

     private TrangThaiSinhVien(final String code) {
         this.code = code;
     }

     public String getCode() {
         return this.code;
     }
}
