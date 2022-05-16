package com.solienlac.khoaluan.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solienlac.khoaluan.web.domain.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Integer> {
    TaiKhoan findByTenDangNhap(String tenDangNhap);
    
    
}
