package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.BangDiemTongKet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiemTongKetRepository extends JpaRepository<BangDiemTongKet,Integer> {
}
