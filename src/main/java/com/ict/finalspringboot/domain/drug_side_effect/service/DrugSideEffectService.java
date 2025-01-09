package com.ict.finalspringboot.domain.drug_side_effect.service;

import java.util.List;


import com.ict.finalspringboot.domain.drug_side_effect.vo.DSEVO;

public interface DrugSideEffectService {

    // 조회 불러오기

    List<DSEVO> dSEinfoList();

    // 수정하기
    int dSEinfoUpdate(DSEVO dvo);

    // 삭제하기
    int dSEinfoDelete(int drug_side_effect_idx);

    // 상세보기
    DSEVO getdSEDetail(int drug_side_effect_idx);

    // 생성하기
    int dSEinfoWrite(DSEVO dvo);

}