package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.ThongBao_Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoLopRepository extends JpaRepository<ThongBao_Lop,Integer> {
}
