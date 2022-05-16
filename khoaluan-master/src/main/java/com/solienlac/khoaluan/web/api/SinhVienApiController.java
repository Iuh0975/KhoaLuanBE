package com.solienlac.khoaluan.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solienlac.khoaluan.web.common.dto.GetDiemSinhVien;
import com.solienlac.khoaluan.web.common.dto.LopHocPhanOfSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import com.solienlac.khoaluan.web.common.dto.param.XinNghiHocParam;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocCustomRepository;
import com.solienlac.khoaluan.web.repository.ThongBaoCustomRepository;
import com.solienlac.khoaluan.web.service.DiemService;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import com.solienlac.khoaluan.web.service.LopHocPhanService;
import com.solienlac.khoaluan.web.service.SinhVienService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/sinhvien")
public class SinhVienApiController {
    private final DonXinNghiHocService donXinNghiHocService;
    private final SinhVienService sinhVienService;
    private final DiemService diemService;
    private final LopHocPhanService lopHocPhanService;
    private final ThongBaoCustomRepository thongBaoCustomRepository;
    private final DonXinNghiHocCustomRepository donXinNghiHocCustomRepository;

    @PostMapping("/donxinnghihoc/{idSinhVien}/{idLopHocPhan}")
    public Integer postDonXinNghiHoc(@PathVariable("idSinhVien") Integer idSinhVien
            , @PathVariable("idLopHocPhan") Integer idLopHocPhan, @RequestBody PostDonXinNghiHoc postDonXinNghiHoc){
        return donXinNghiHocService.xinNghiHoc(idSinhVien,idLopHocPhan,postDonXinNghiHoc);
    }

    @GetMapping("/thongtin/{id}")
    public ThongTinSinhVienDto xemThongTin(@PathVariable("id") Integer id){
        return sinhVienService.xemThongTin(id);
    }

    @PutMapping("/thongtin/{id}")
    public Integer chinhSuaThongTin(@PathVariable("id") Integer id, @RequestBody PutSinhVienParam putSinhVienParam){
        return sinhVienService.chinhSuaSinhVien(id,putSinhVienParam);
    }


    /**
     * 
     * @param idSinhVien
     * @return
     *  
            "id": 25,
            "tieuDe": "Thong bao demo",
            "thongBaoType": "TB_LOP",
            "noiDung": "noi dung thong bao demo",
            "ngayTao": 1647622800000,
            "tenGiangVien": "Vũ Đức Thiện"
     */

    @GetMapping("/{idSinhVien}/thongbaos")
    public Object getThongBaoByIdSinhVien(@PathVariable("idSinhVien") Integer idSinhVien){
    	
    	List<Object> liObjects = new ArrayList<Object>();
    	liObjects.addAll(thongBaoCustomRepository.listThongBaoLopHocPhan(idSinhVien));
    	liObjects.addAll(thongBaoCustomRepository.listThongBaoLop(idSinhVien));
    	
        return new ResponseEntity<Object>(liObjects,HttpStatus.OK);


    }

    @GetMapping("/{idSinhVien}/diem")
    public GetDiemSinhVien getDonXinNghiHoc(@PathVariable("idSinhVien") Integer idSinhVien){
        return diemService.getDiemSinhViens(idSinhVien);
    }
    //
    @GetMapping("/{idSinhVien}/lophocphan")
    public List<LopHocPhanOfSinhVienDto> getLopHocPhan(@PathVariable("idSinhVien") Integer idSinhVien){
        return lopHocPhanService.getLopHocPhanOfSinhVien(idSinhVien);
    }
    @PostMapping("/donxinnghihoc")
    public Integer xinNghiHoc(@RequestBody XinNghiHocParam xinNghiHocParam){
        return donXinNghiHocService.xinNghiHoc(xinNghiHocParam);
    }

    
    /**
     * 
     * @param idSinhVien
     * @return
     *      "idDonXinNghiHoc": 10,
        "idSinhVien": 2,
        "maSV": "sv68a0",
        "tenSinhVien": "Phạm Quốc Toàn",
        "tenLopHocPhan": "Đại Học Âm Nhạc Dân Tộc",
        "ngayNghi": 1640106000000,
        "ngayTao": "2021-12-18T17:00:00.000+00:00",
        "trangThai": true,
        "noiDung": "Thưa cô em xin nghỉ học vì hôm đấy em sẽ về quê khám nghĩa vụ"
     */
    @GetMapping("/{idSinhVien}/donxinnghihoc")
    public Object donNghiHocs(@PathVariable("idSinhVien") Integer idSinhVien){
        return new ResponseEntity<Object>(donXinNghiHocCustomRepository.getListDonXinHocByIdSinhVien(idSinhVien),HttpStatus.OK);
    }

}
