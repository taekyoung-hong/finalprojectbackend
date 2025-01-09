package com.ict.finalspringboot.domain.box_info.controller;

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
import com.ict.finalspringboot.domain.box_info.service.BoxService;
import com.ict.finalspringboot.domain.box_info.vo.BoxVO;
import com.ict.finalspringboot.domain.phar_info.vo.pharVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/box_info")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/list")
    public DataVO BoxinfoList() {
        DataVO dataVO = new DataVO();
        try {
            List<BoxVO> list = boxService.BoxinfoList();

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
    public DataVO BoxinfoWrite(
            @RequestBody BoxVO bvo) {

        DataVO dataVO = new DataVO();
        try {
            log.info("Received data: " + bvo.toString());
            // 약국 쓰기
            int result = boxService.BoxinfoWrite(bvo);

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
    @GetMapping("/detail/{box_idx}")
    public DataVO getpharsDetail(@PathVariable("box_idx") int box_idx) {
        DataVO dataVO = new DataVO();

        try {
            log.info("box_idx : " + box_idx);
            BoxVO bvo = boxService.getboxsDetail(box_idx);
            if (bvo == null) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 상세보기 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 상세보기 성공");
            dataVO.setData(bvo);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 상세보기 실패");
        }
        return dataVO;
    }

    @PostMapping("/delete/{box_idx}")
    public DataVO BoxinfoDelete(@PathVariable("box_idx") int box_idx) {
        DataVO dataVO = new DataVO();
        try {

            int result = boxService.BoxinfoDelete(box_idx);
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
    public DataVO pharinfoUpdate(@RequestBody BoxVO bvo) {
        DataVO dataVO = new DataVO();
        try {
            log.info("null");
            log.info("pvo : " + bvo);
            int result = boxService.BoxinfoUpdate(bvo);

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
