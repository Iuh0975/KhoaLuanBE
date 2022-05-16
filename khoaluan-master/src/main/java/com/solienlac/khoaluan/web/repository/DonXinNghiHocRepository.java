package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonXinNghiHocRepository extends JpaRepository<DonXinNghiHoc,Integer> {
}
