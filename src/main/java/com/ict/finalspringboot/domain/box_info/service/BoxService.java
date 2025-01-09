package com.ict.finalspringboot.domain.box_info.service;

import java.util.List;

import com.ict.finalspringboot.domain.box_info.vo.BoxVO;

public interface BoxService {

    // 조회 불러오기

    List<BoxVO> BoxinfoList();

    // 수정하기
    int BoxinfoUpdate(BoxVO bvo);

    // 삭제하기
    int BoxinfoDelete(int box_idx);

    // 생성하기
    int BoxinfoWrite(BoxVO pvo);

    // 상세보기
    BoxVO getboxsDetail(int box_idx);

}