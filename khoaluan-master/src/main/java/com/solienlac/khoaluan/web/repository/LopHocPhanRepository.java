package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan,Integer> {
}
