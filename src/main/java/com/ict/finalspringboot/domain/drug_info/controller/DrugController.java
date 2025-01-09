package com.ict.finalspringboot.domain.drug_info.controller;

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
import com.ict.finalspringboot.domain.drug_info.service.DrugService;
import com.ict.finalspringboot.domain.drug_info.vo.DrugVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/drug_info")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping("/list")
    public DataVO druginfoList() {
        DataVO dataVO = new DataVO();
        try {
            List<DrugVO> list = drugService.druginfoList();

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
            @RequestBody DrugVO dvo) {

        DataVO dataVO = new DataVO();
        try {
            log.info("Received data: " + dvo.toString());
            // 약국 쓰기
            int result = drugService.druginfoWrite(dvo);

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
    @GetMapping("/detail/{drug_info_idx}")
    public DataVO getdrugsDetail(@PathVariable("drug_info_idx") int drug_idx) {
        DataVO dataVO = new DataVO();

        try {
            log.info("drug_idx : " + drug_idx);
            DrugVO dvo = drugService.getdrugsDetail(drug_idx);
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

    @GetMapping("/delete/{drug_info_idx}")
    public DataVO getdrugDelete(@PathVariable("drug_info_idx") int drug_idx) {
        DataVO dataVO = new DataVO();
        try {

            int result = drugService.druginfoDelete(drug_idx);
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
    public DataVO druginfoUpdate(@RequestBody DrugVO dvo) {
        DataVO dataVO = new DataVO();
        try {
            log.info("null");
            log.info("dvo : " + dvo);
            int result = drugService.druginfoUpdate(dvo);

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
