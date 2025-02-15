package com.ict.finalspringboot.domain.phar_info.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/phar_info")
public class PharController {

    @Autowired
    private PharService pharService;

    @GetMapping("/list")
    public DataVO getpharList() {
        DataVO dataVO = new DataVO();
        try {
            List<pharVO> list = pharService.pharinfoList();

            log.info("data", list);
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

    @PostMapping("/write")
    public DataVO getpharWrite(
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

    // 상세보기
    @GetMapping("/detail/{phar_idx}")
    public DataVO getpharsDetail(@PathVariable("phar_idx") int phar_idx) {
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

    @PostMapping("/delete/{phar_idx}")
    public DataVO getpharDelete(@PathVariable("phar_idx") int phar_idx) {

        DataVO dataVO = new DataVO();
        try {
            log.info("delete phar_dx", phar_idx);
            int result = pharService.getpharDelete(phar_idx);
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

    @PostMapping("/update")
    public DataVO pharinfoUpdate(@RequestBody pharVO pvo) {
        DataVO dataVO = new DataVO();
        try {
            log.info("null");
            log.info("pvo : " + pvo);
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

    // @DeleteMapping("/delete/{phar_idx}")
    // public DataVO pharinfoDelete(@PathVariable int phar_idx) {
    // DataVO dataVO = new DataVO();
    // try {
    // log.info("Deleting pharmacy with ID: " + phar_idx);
    // int result = pharService.pharinfoDelete(phar_idx);

    // if (result == 0) {
    // log.info("Deletion failed for ID: " + phar_idx);
    // dataVO.setSuccess(false);
    // dataVO.setMessage("약국 삭제 실패");
    // return dataVO;
    // }
    // dataVO.setSuccess(true);
    // dataVO.setMessage("약국 삭제 성공");

    // } catch (Exception e) {
    // log.error("Exception occurred while deleting pharmacy", e);
    // dataVO.setSuccess(false);
    // dataVO.setMessage("약국 삭제 중 오류 발생");
    // }
    // return dataVO;
    // }

}
