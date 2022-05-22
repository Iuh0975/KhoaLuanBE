package com.solienlac.khoaluan.web.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.solienlac.khoaluan.web.common.dto.fix.ThoiHocDto;
import com.solienlac.khoaluan.web.common.dto.param.PostSmsCanhBao;
import com.solienlac.khoaluan.web.config.TwilioConfig;
import com.solienlac.khoaluan.web.domain.CanhBao;
import com.solienlac.khoaluan.web.domain.GiangVien;
import com.solienlac.khoaluan.web.domain.PhuHuynh;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;
import com.solienlac.khoaluan.web.repository.CanhBaoCustomRepository;
import com.solienlac.khoaluan.web.repository.CanhBaoRepository;
import com.solienlac.khoaluan.web.repository.GiangVienRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.SmsSenderService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SmsSenderServiceImpl implements SmsSenderService {
    private final TwilioConfig twilioConfig ;
    private final SinhVienRepository sinhVienRepository;
    private final GiangVienRepository giangVienRepository;
    private final CanhBaoRepository canhBaoRepository;
    private final CanhBaoCustomRepository canhBaoCustomRepository;
    @Value("twilio.account_sid")
    private String account_sid;
    @Value("twilio.auth_token")
    private String auth_token;
    @Value("twilio.phone_nummber")
    private String phone_nummber;

    @Override
    public Integer senderSms(PostSmsCanhBao thongTinCanhBao) throws IllegalAccessException {
        SinhVien sinhVien = sinhVienRepository.findById(thongTinCanhBao.getIdSinhVien()).orElse(null);

        PhuHuynh phuHuynh = sinhVien.getPhuHuynh();
        GiangVien giangVien = giangVienRepository.findById(thongTinCanhBao.getIdGiangVien()).orElse(null);
        
        ThoiHocDto thoiHocDto = canhBaoCustomRepository.checkSoLanCanhBao(thongTinCanhBao.getIdSinhVien());
  
        int soLan = thoiHocDto.getSlCanhBao() + 1;
                
        if (isPhoneNumberValid(sinhVien.getSoDienThoai()
                ,phuHuynh.getSoDienThoai())){
            Twilio.init(twilioConfig.getAccount_sid(), twilioConfig.getAuth_token());
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhone_nummber());


            PhoneNumber toPhuHuynh = new PhoneNumber(phuHuynh.getSoDienThoai());
            PhoneNumber toSinhVien = new PhoneNumber(sinhVien.getSoDienThoai());
            
            
            
            String importantMessage = "Đây là lần cảnh báo thứ " + soLan + "\n" + "Cảnh báo lần 3 sẽ buộc sinh viên thôi học";
            String thoiHocMessage = "Anh/Chị đã bị buộc thôi học do bị cảnh báo 3 lần. Thông tin liên hệ tới khoa !!!!";
            String message =thongTinCanhBao.getTieuDe()+" \n "+ thongTinCanhBao.getNoiDung() + "\n " + importantMessage;
            String endMessage =thongTinCanhBao.getTieuDe()+" \n "+ thongTinCanhBao.getNoiDung() + "\n " + thoiHocMessage;
            
            MessageCreator creatorPhuHuynh = null;
            MessageCreator creatorSinhVien = null;
            
            // Lần 3 sẽ bị thôi học
            if(soLan >= 3 ) {
            	
            	// update trang thai thoi hoc
            	canhBaoCustomRepository.updateTrangThaiThoiHoc(TrangThaiSinhVien.THOI_HOC, thongTinCanhBao.getIdSinhVien());
                creatorPhuHuynh = Message.creator(toPhuHuynh,from,endMessage);
                creatorSinhVien = Message.creator(toSinhVien,from,endMessage);
            	
            }else {
                 creatorPhuHuynh = Message.creator(toPhuHuynh,from,message);
                 creatorSinhVien = Message.creator(toSinhVien,from,message);
            }
    
            
            creatorPhuHuynh.create();
            creatorSinhVien.create();
            CanhBao canhBao = new CanhBao(thongTinCanhBao.getTieuDe(),thongTinCanhBao.getNoiDung(),giangVien,sinhVien);
            canhBaoRepository.save(canhBao);
            return canhBao.getId();

        }else{
            throw new IllegalAccessException("Phone number error! ");
        }

    }

    private boolean isPhoneNumberValid(String phoneSinhVien,String phoneGiangVien) {
        if (phoneSinhVien.equalsIgnoreCase("")||phoneGiangVien.equalsIgnoreCase("")){
            return false;
        }
        return true;
    }
}
