package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop,Integer> {
}
