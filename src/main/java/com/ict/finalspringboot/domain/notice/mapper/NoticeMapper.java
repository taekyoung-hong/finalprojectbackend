package com.ict.finalspringboot.domain.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ict.finalspringboot.domain.notice.vo.NoticeVO;

@Mapper
public interface NoticeMapper {

    List<NoticeVO> noticeList();

    int getNoticeWrite(NoticeVO nvo);

}
