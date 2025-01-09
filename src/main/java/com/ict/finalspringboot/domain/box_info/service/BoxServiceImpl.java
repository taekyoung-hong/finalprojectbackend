package com.ict.finalspringboot.domain.box_info.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.finalspringboot.domain.box_info.mapper.BoxMapper;
import com.ict.finalspringboot.domain.box_info.vo.BoxVO;

@Service
public class BoxServiceImpl implements BoxService {

    @Autowired
    private BoxMapper boxMapper;

    @Override
    public List<BoxVO> BoxinfoList() {
     return boxMapper.BoxinfoList();
    }

    @Override
    public int BoxinfoUpdate(BoxVO bvo) {
       return boxMapper.BoxinfoUpdate(bvo);
    }

    @Override
    public int BoxinfoDelete(int box_idx) {
       return boxMapper.BoxinfoDelete(box_idx);
    }

    @Override
    public int BoxinfoWrite(BoxVO pvo) {
       return boxMapper.BoxinfoWrite(pvo);
    }

    @Override
    public BoxVO getboxsDetail(int box_idx) {
       return boxMapper.getboxsDetail(box_idx);
    }

  
}