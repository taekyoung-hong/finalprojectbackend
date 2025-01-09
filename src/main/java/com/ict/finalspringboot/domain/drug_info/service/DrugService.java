package com.ict.finalspringboot.domain.drug_info.service;

import java.util.List;

import com.ict.finalspringboot.domain.drug_info.vo.DrugVO;

public interface DrugService {

    // 조회 불러오기

    List<DrugVO> druginfoList();

    // 수정하기
    int druginfoUpdate(DrugVO pvo);

    // 삭제하기
    int druginfoDelete(int drug_idx);

    // 생성하기
    int druginfoWrite(DrugVO pvo);

    // 상세보기
    DrugVO getdrugsDetail(int drug_idx);

}