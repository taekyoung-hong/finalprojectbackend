package com.ict.finalspringboot.domain.notice.service;

import java.util.List;
import com.ict.finalspringboot.domain.notice.vo.NoticeVO;



public interface NoticeService {

    // 조회 불러오기
    List<NoticeVO> noticeList();

    int getNoticeWrite(NoticeVO nvo);
    
}