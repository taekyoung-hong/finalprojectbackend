package com.ict.finalspringboot.domain.qna_tbl.service;

import java.util.List;

import com.ict.finalspringboot.domain.qna_tbl.vo.QnaVO;



public interface QnaService {

    // 조회 불러오기
    List<QnaVO> qnaList();


}