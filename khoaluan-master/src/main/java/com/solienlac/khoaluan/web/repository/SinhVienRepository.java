package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien,Integer> {
        SinhVien findByMaSinhVien(String maSinhVien);
}
