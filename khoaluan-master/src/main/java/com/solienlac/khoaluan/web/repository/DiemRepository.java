package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.BangDiemTongKet;
import com.solienlac.khoaluan.web.domain.BangDiem_SinhVien_MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiemRepository extends JpaRepository<BangDiem_SinhVien_MonHoc,Integer> {
    List<BangDiem_SinhVien_MonHoc> findAllByBangDiemTongKet(BangDiemTongKet bangDiemTongKet);
}
