package com.ict.finalspringboot.domain.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.notice.mapper.NoticeMapper;
import com.ict.finalspringboot.domain.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<NoticeVO> noticeList() {
        return noticeMapper.noticeList();
    }

    @Override
    public int getNoticeWrite(NoticeVO nvo) {
        return noticeMapper.getNoticeWrite(nvo);
    }

}
