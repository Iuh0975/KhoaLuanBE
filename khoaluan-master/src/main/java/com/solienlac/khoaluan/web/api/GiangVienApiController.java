package com.solienlac.khoaluan.web.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.solienlac.khoaluan.web.common.dto.NgayNghiDto;
import com.solienlac.khoaluan.web.common.dto.fix.GetLopHocByIdSinhVien;
import com.solienlac.khoaluan.web.common.dto.fix.GetThongBaoLop;
import com.solienlac.khoaluan.web.common.dto.param.PostDiemDanh;
import com.solienlac.khoaluan.web.common.dto.param.PostSmsCanhBao;
import com.solienlac.khoaluan.web.common.dto.param.PostThongBaoLop;
import com.solienlac.khoaluan.web.common.dto.param.PutBangDiemSinhVien;
import com.solienlac.khoaluan.web.repository.CanhBaoCustomRepository;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocCustomRepository;
import com.solienlac.khoaluan.web.repository.LopHocPhanCustomRepository;
import com.solienlac.khoaluan.web.repository.LopQueryRepository;
import com.solienlac.khoaluan.web.service.DiemService;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import com.solienlac.khoaluan.web.service.NgayNghiService;
import com.solienlac.khoaluan.web.service.SmsSenderService;
import com.solienlac.khoaluan.web.service.ThongBaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/giangvien")
public class GiangVienApiController {


    private final SmsSenderService service;

    private final DonXinNghiHocService donXinNghiHocService;
    private final ThongBaoService thongBaoService;


    private final DiemService diemService;
    private final NgayNghiService ngayNghiService;
    private final LopQueryRepository lopQueryRepository;
    private final LopHocPhanCustomRepository lopHocPhanCustomRepository;
    private final DonXinNghiHocCustomRepository donXinNghiHocCustomRepository;
    private final CanhBaoCustomRepository canhBaoCustomRepository;
    
    @GetMapping("/{idGiangVien}/danhsachlophoc")
    public ResponseEntity<Object> getLops(@PathVariable("idGiangVien") int idGiangVien){

        return new ResponseEntity<Object>(lopQueryRepository.getLop(idGiangVien),HttpStatus.OK);
    }
    
    @GetMapping("/{idGiangVien}/danhsachlophocphan")
    public ResponseEntity<Object> getLopHocPhans(@PathVariable("idGiangVien") Integer idGiangVien){
    	
        return new ResponseEntity<Object>(lopHocPhanCustomRepository.getLopHocPhan(idGiangVien),HttpStatus.OK);
    }


      /*
        Send message to phuHuynh and hocSinh 
        Check số lần cảnh báo >= 3 ==> thôi học
      */
    @PostMapping("/canhbao")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer smsCanhBaoSinhVien(@RequestBody PostSmsCanhBao thongTinCanhBao) throws IllegalAccessException {
        return service.senderSms(thongTinCanhBao);
    }
    /**
     * 
     * @param idGiangVien
     * @param idDonNghiHoc
     * @return
     */
    
    // update trạng thái thôi học

    @PutMapping("/donnghihoc/{idGiangVien}/{idDonNghiHoc}")
    @ResponseStatus(HttpStatus.OK)
    public Integer duyetDonNghiHoc(@PathVariable("idGiangVien") Integer idGiangVien,
                                   @PathVariable("idDonNghiHoc") Integer idDonNghiHoc){
        return donXinNghiHocService.duyetDonXinNghiHoc(idGiangVien,idDonNghiHoc);
    }

    @GetMapping("/{idGiangVien}/{idLopHocPhan}/list-donxinnghihoc")
    public ResponseEntity<Object> getDonXinNghiHoc(@PathVariable("idGiangVien") Integer idGiangVien,@PathVariable("idLopHocPhan") Integer idLopHocPhan){

    	return new ResponseEntity<Object>(donXinNghiHocCustomRepository.getListDonXinHocByIdGiangVien(idLopHocPhan, idGiangVien),HttpStatus.OK);


    }
    
    @GetMapping("/{idLopHoc}/sinhvien")
    public ResponseEntity<Object> getSinhVienLopHoc(@PathVariable("idLopHoc") Integer idLopHoc){

    	List<GetLopHocByIdSinhVien> list = lopQueryRepository.getSinhVienByLopHoc(idLopHoc).stream().map(sv -> new GetLopHocByIdSinhVien(sv)).collect(Collectors.toList());

    	return new ResponseEntity<Object>(list,HttpStatus.OK);
    }

    @GetMapping("/{idLopHocPhan}/lophocphan/sinhvien")
    public Object getSinhVienLopHocPhan(@PathVariable("idLopHocPhan") Integer idLopHocPhan){
        return new ResponseEntity<Object>(lopHocPhanCustomRepository.getSinhVienByIdLHP(idLopHocPhan),HttpStatus.OK);
    }


    @GetMapping("/{idGiangVien}/{idLopHoc}/thongbaolop")
    public Object getThongBaoLopOfGiangVien(@PathVariable("idGiangVien") Integer idLopHoc,@PathVariable("idLopHoc") Integer idGiangVien){
    	List<GetThongBaoLop> list = lopQueryRepository.getThongBaoLopById(idLopHoc, idGiangVien);
        return new ResponseEntity<Object>(list,HttpStatus.OK);
    }
    
    @GetMapping("/{idGiangVien}/{idLopHoc}/thongbaolophocphan")
    public Object getThongBaoLopHocPhanOfGiangVien(@PathVariable("idGiangVien") Integer idLopHoc,@PathVariable("idLopHoc") Integer idGiangVien){
        return new ResponseEntity<Object>(lopHocPhanCustomRepository.getThongBaoLopById(idGiangVien, idLopHoc),HttpStatus.OK);
    }


    @PostMapping("/{idGiangVien}/{idLop}/thongbaolop")
    public Integer taoThongBaoLopHoc(@PathVariable("idGiangVien") Integer idGiangVien, @PathVariable("idLop") Integer idLop
            , @RequestBody PostThongBaoLop postThongBaoLop){
        return thongBaoService.themThongBaoLop(idGiangVien,idLop,postThongBaoLop);
    }

    @PostMapping("/{idGiangVien}/{idLopHocPhan}/thongbaolophocphan")
    public Integer taoThongBaoLopHocPhan(@PathVariable("idGiangVien") Integer idGiangVien, @PathVariable("idLopHocPhan") Integer idLopHocPhan
            , @RequestBody PostThongBaoLop postThongBaoLop){
        return thongBaoService.themThongBaoLopHocPhan(idGiangVien,idLopHocPhan,postThongBaoLop);
    }


    @PutMapping("/{idThongBao}/thongbaolop")
    public Integer chinhSuaThongBaoLopHoc(@PathVariable("idThongBao") Integer idThongBao
            , @RequestBody PostThongBaoLop postThongBaoLop){
        return thongBaoService.chinhSuaThongBaoLop(idThongBao,postThongBaoLop);
    }

    @PutMapping("/{idThongBao}/thongbaolop/hienthi")
    public Integer chinhSuaHienThiThongBaoLopHoc(@PathVariable("idThongBao") Integer idThongBao){
        return thongBaoService.chinhSuaHienThiThongBaoLop(idThongBao);
    }

    @GetMapping("/{idGiangVien}/{idSinhVien}/canhbao")
    public Object getCanhBaoSinhVienOfLopHOc(@PathVariable("idGiangVien") Integer idGiangVien,
                                                       @PathVariable("idSinhVien") Integer idSinhVien){
        return new ResponseEntity<Object>(canhBaoCustomRepository.listCanhBaoSinhVien(idSinhVien, idGiangVien),HttpStatus.OK);
    }

    @PutMapping("/{idBangDiem}/monhoc/bangdiem")
    public Integer chinhSuaBangDiemSinhVienMonHoc(@PathVariable("idBangDiem") Integer idBangDiem,
                                                  @RequestBody PutBangDiemSinhVien putBangDiemSinhVien){
        return diemService.chinhSuaBangDiemSinhVienMonHoc(idBangDiem,putBangDiemSinhVien);
    }

    @PostMapping("/{idSinhVien}/{idLopHocPhan}/diemdanh")
    public Integer diemDanh(@PathVariable("idSinhVien") Integer idSinhVien,
                                                  @PathVariable("idLopHocPhan") Integer idLopHocPhan,
                                                  @RequestBody PostDiemDanh postDiemDanh){
        return donXinNghiHocService.diemDanh(idSinhVien, idLopHocPhan, postDiemDanh);
    }

    @GetMapping("/{idSinhVienLhp}/ngaynghis")
    public List<NgayNghiDto> getNgayNghis(@PathVariable Integer idSinhVienLhp){
        return ngayNghiService.listNgayNghiDtoOfSinhVienLhp(idSinhVienLhp);
    }

    @DeleteMapping("/ngaynghis/{id}")
    public ResponseEntity<Void> xoaNgayNghi(@PathVariable Integer id){
        return ngayNghiService.xoaNgayNghi(id);
    }

}
