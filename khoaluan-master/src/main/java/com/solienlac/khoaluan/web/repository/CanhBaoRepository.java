package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.CanhBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanhBaoRepository extends JpaRepository<CanhBao,Integer> {
}
