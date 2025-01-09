package com.ict.finalspringboot.domain.fna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.fna.service.FnaService;
import com.ict.finalspringboot.domain.fna.vo.FnaVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/fna")
public class FnaController {
   
    @Autowired
       private FnaService fnaService;


    @GetMapping("/list")
    public DataVO fnaList() {
        DataVO dataVO = new DataVO();
        try {
            List<FnaVO> list = fnaService.FnaList();
            // 리스트가 null일 경우 빈 리스트로 초기화
            if (list == null) {
                list = new ArrayList<>(); // 빈 리스트로 초기화
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("Qna 조회 성공");
            dataVO.setData(list);

        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("Qna 조회 실패");
            e.getStackTrace();
        }
        return dataVO;
    }

 
}
