package com.ict.finalspringboot.domain.qna_tbl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.qna_tbl.vo.QnaVO;


@Mapper
public interface QnaMapper {

    List<QnaVO> qnaList();



}
