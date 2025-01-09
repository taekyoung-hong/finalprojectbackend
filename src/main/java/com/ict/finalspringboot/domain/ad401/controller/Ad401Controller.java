package com.ict.finalspringboot.domain.ad401.controller;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.ad401.service.Ad401Service;
import com.ict.finalspringboot.domain.ad401.vo.Ad401VO;
import com.ict.finalspringboot.domain.auth.vo.DataVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ad401")
public class Ad401Controller {

    @Autowired
    private Ad401Service ad401Service;

    @GetMapping("/list")
    public DataVO ad401List() {
        DataVO dataVO = new DataVO();
        try {
            List<Ad401VO> list = ad401Service.ad401List();

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
    public DataVO getAd401Write(
            @RequestBody Ad401VO avo) {

        DataVO dataVO = new DataVO();
        try {
            log.info("Received data: " + avo.toString());
            // 약국 쓰기
            int result = ad401Service.getAd401Write(avo);

            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 쓰기 실패");

                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 쓰기 성공");

        } catch (Exception e) {
            log.error("Exception occurred while writing ad401macy", e); // 스택 트레이스 출력
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 쓰기 오류 발생");
        }
        return dataVO;
    }

    // 상세보기
    @GetMapping("/detail/{ad401_idx}")
    public DataVO getAd401Idx(@PathVariable("ad401_idx") int ad401_idx) {
        DataVO dataVO = new DataVO();

        try {
            log.info("ad401_idx : " + ad401_idx);
            Ad401VO avo = ad401Service.getAd401Idx(ad401_idx);
            if (avo == null) {
                dataVO.setSuccess(false);
                dataVO.setMessage("약국 상세보기 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("약국 상세보기 성공");
            dataVO.setData(avo);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("약국 상세보기 실패");
        }
        return dataVO;
    }

    @GetMapping("/delete/{ad401_idx}")
    public DataVO getad401Delete(@PathVariable int ad401_idx) {
        DataVO dataVO = new DataVO();
        try {

            int result = ad401Service.getAd401Delete(ad401_idx);
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
    public DataVO getAd401Update(@RequestBody Ad401VO avo) {
        DataVO dataVO = new DataVO();
        try {
            log.info("null");
            log.info("avo : " + avo);
            int result = ad401Service.getAd401Update(avo);

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
