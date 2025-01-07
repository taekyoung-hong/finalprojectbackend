package com.ict.finalspringboot.domain.ad401.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.ad401.vo.Ad401VO;


@Mapper
public interface Ad401Mapper {

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
