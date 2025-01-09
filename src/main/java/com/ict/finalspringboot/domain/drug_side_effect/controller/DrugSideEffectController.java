package com.ict.finalspringboot.domain.drug_side_effect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.drug_info.vo.DrugVO;
import com.ict.finalspringboot.domain.drug_side_effect.service.DrugSideEffectService;
import com.ict.finalspringboot.domain.drug_side_effect.vo.DSEVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/drug_side_effect")
public class DrugSideEffectController {

    @Autowired
    private DrugSideEffectService drugSideEffectService;

    @GetMapping("/list")
    public DataVO dSEinfoList() {
        DataVO dataVO = new DataVO();
        try {
            List<DSEVO> list = drugSideEffectService.dSEinfoList();

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
    public DataVO getdrugWrite(
            @RequestBody DSEVO dvo) {

        DataVO dataVO = new DataVO();
        try {
            log.info("Received data: " + dvo.toString());
            // 약국 쓰기
            int result = drugSideEffectService.dSEinfoWrite(dvo);

            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 쓰기 실패");

                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 쓰기 성공");

        } catch (Exception e) {
            log.error("Exception occurred while writing drugmacy", e); // 스택 트레이스 출력
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 쓰기 오류 발생");
        }
        return dataVO;
    }

    // 상세보기
    @GetMapping("/detail/{drug_side_effect_idx}")
    public DataVO getdSEDetail(@PathVariable("drug_side_effect_idx") int drug_side_effect_idx) {
        DataVO dataVO = new DataVO();

        try {
            log.info("drug_idx : " + drug_side_effect_idx);
            DSEVO dvo = drugSideEffectService.getdSEDetail(drug_side_effect_idx);
            if (dvo == null) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 상세보기 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 상세보기 성공");
            dataVO.setData(dvo);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 상세보기 실패");
        }
        return dataVO;
    }

    @GetMapping("/delete/{drug_side_effect_idx}")
    public DataVO getdrugDelete(@PathVariable("drug_side_effect_idx") int drug_side_effect_idx) {
        DataVO dataVO = new DataVO();
        try {

            int result = drugSideEffectService.dSEinfoDelete(drug_side_effect_idx);
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
    public DataVO druginfoUpdate(@RequestBody DSEVO dvo) {
        DataVO dataVO = new DataVO();
        try {
            log.info("null");
            log.info("dvo : " + dvo);
            int result = drugSideEffectService.dSEinfoUpdate(dvo);

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
