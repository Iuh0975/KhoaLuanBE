package com.solienlac.khoaluan.web.repository;


import com.solienlac.khoaluan.web.domain.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien,Integer> {
    GiangVien findByMaGiangVien(String maGiangVien);
}
