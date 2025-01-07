package com.ict.finalspringboot.domain.qna_tbl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.qna_tbl.service.QnaService;
import com.ict.finalspringboot.domain.qna_tbl.vo.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/qna_tbl")
public class QnaController {
   
    @Autowired
    private QnaService qnaService;


    @GetMapping("/list")
    public DataVO qnaList() {
        DataVO dataVO = new DataVO();
        try {
            List<QnaVO> list = qnaService.qnaList();
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
