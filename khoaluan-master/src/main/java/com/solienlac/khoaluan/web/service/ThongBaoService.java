package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.param.PostThongBaoLop;

public interface ThongBaoService {




    Integer themThongBaoLop(Integer idGiangVien,Integer idLop,PostThongBaoLop postThongBaoLop);
    Integer themThongBaoLopHocPhan(Integer idGiangVien,Integer idLopHocPhan,PostThongBaoLop postThongBaoLop);



    Integer chinhSuaThongBaoLop(Integer idThongBao, PostThongBaoLop postThongBaoLop);



    Integer chinhSuaHienThiThongBaoLop(Integer idThongBao);
}
