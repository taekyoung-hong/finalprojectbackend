package com.ict.finalspringboot.domain.qna_tbl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.finalspringboot.domain.qna_tbl.mapper.QnaMapper;
import com.ict.finalspringboot.domain.qna_tbl.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {

    @Autowired
    private QnaMapper qnaMapper;

    @Override
    public List<QnaVO> qnaList() {
    
       List<QnaVO> list = qnaMapper.qnaList();
        if (list == null) {
            list = new ArrayList<>(); // null일 경우 빈 리스트로 초기화
            System.out.println("데이터가 없습니다.");
        }
        return list;
    }

   
}
