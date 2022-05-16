package com.solienlac.khoaluan.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solienlac.khoaluan.web.domain.NgayNghi;

@Repository
public interface NgayNghiRepository extends JpaRepository<NgayNghi,Integer> {
}
