package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.ThongBao_LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoLopHocPhanRepository extends JpaRepository<ThongBao_LopHocPhan,Integer> {
}
