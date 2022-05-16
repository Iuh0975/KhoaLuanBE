package com.solienlac.khoaluan.web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Entity
@Table(name = "bangdiemtongket")
@NoArgsConstructor
@Getter
@Log4j2
public class BangDiemTongKet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diemTbTL")
    private double trungBinhTichLuy;


    @OneToOne(mappedBy = "bangDiemTongKet")
    private SinhVien sinhVien;



    @OneToMany(mappedBy = "bangDiemTongKet")
    private List<BangDiem_SinhVien_MonHoc> bangDiem_sinhVien_monHocs = new ArrayList<>();

    public BangDiemTongKet(double trungBinhTichLuy) {
        this.trungBinhTichLuy = trungBinhTichLuy;
    }

    public void setBangDiemTongKet(List<BangDiem_SinhVien_MonHoc> list){
        final double[] diemsinhvien = {0};
         list.forEach(diem ->{
             diemsinhvien[0] = diemsinhvien[0] +diem.getDiemTBC();
         });
         if (diemsinhvien[0]>0){
             this.trungBinhTichLuy = diemsinhvien[0]/list.size();
         }else {
             this.trungBinhTichLuy=0;
         }
    }

}
