package com.ict.finalspringboot.domain.ad401.service;

import java.util.List;

import com.ict.finalspringboot.domain.ad401.vo.Ad401VO;

public interface Ad401Service {

    // 조회 불러오기

    List<Ad401VO> ad401List();

    // 수정하기
    int getAd401Delete(Ad401VO avo);

    // 삭제하기
    int getAd401Delete(String ad401_idx);

    // 생성하기
    int getAd401Write(Ad401VO avo);

    // 상세보기
    Ad401VO getAd401Idx(String ad401_idx);

}