package com.ict.finalspringboot.domain.ad401.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.phar_info.service.PharService;
import com.ict.finalspringboot.domain.phar_info.vo.pharVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ad401")
public class Ad401Controller {

    @Autowired
    private PharService pharService;

    @PostMapping("/write")
    public DataVO getAd401Write(
            @RequestBody pharVO pvo) {

        DataVO dataVO = new DataVO();
        try {
            log.info("Received data: " + pvo.toString());
            // 약국 쓰기
            int result = pharService.pharinfoWrite(pvo);

            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 쓰기 실패");

                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 쓰기 성공");

        } catch (Exception e) {
            log.error("Exception occurred while writing pharmacy", e); // 스택 트레이스 출력
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 쓰기 오류 발생");
        }
        return dataVO;
    }

    @GetMapping("/list")
    public DataVO getpharList() {
        DataVO dataVO = new DataVO();
        try {
            List<pharVO> list = pharService.pharinfoList();
            // 리스트가 null일 경우 빈 리스트로 초기화
            if (list == null) {
                list = new ArrayList<>(); // 빈 리스트로 초기화
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 조회 성공");
            dataVO.setData(list);

        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 조회 실패");
            e.getStackTrace();
        }
        return dataVO;
    }

    // 상세보기

    @GetMapping("/detail/{phar_idx}")
    public DataVO getpharsDetail(@PathVariable("phar_idx") String phar_idx) {
        DataVO dataVO = new DataVO();

        try {
            log.info("phar_idx : " + phar_idx);
            pharVO pvo = pharService.getpharsDetail(phar_idx);
            if (pvo == null) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 상세보기 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 상세보기 성공");
            dataVO.setData(pvo);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 상세보기 실패");
        }
        return dataVO;
    }

    @GetMapping("/delete/{phar_idx}")
    public DataVO getpharDelete(@PathVariable String phar_idx) {
        DataVO dataVO = new DataVO();
        try {

            log.info(phar_idx);

            int result = pharService.pharinfoDelete(phar_idx);
            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 삭제 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 삭제 성공");

        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 삭제 오류 발생");
        }
        return dataVO;
    }

    @PutMapping("/update/{phar_idx}")
    public DataVO getpharUpdate(@PathVariable String phar_idx, @RequestBody pharVO pvo) {
        DataVO dataVO = new DataVO();
        try {
            // // 로그인 여부 확인
            // if (authentication == null) {
            // dataVO.setSuccess(false);
            // dataVO.setMessage("로그인이 필요합니다.");
            // return dataVO;
            // }

            // 파라미터 확인
            int result = pharService.pharinfoUpdate(pvo);

            if (result == 0) {
                log.info("result=2");
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 수정 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 수정 성공");

        } catch (Exception e) {
            log.info("Exception");
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 수정 오류 발생");
        }
        return dataVO;
    }

}
