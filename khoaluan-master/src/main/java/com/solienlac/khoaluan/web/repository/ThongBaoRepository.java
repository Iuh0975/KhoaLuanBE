package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao,Integer> {
}
