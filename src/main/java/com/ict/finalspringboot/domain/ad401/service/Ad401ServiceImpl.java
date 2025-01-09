package com.ict.finalspringboot.domain.ad401.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.ad401.mapper.Ad401Mapper;
import com.ict.finalspringboot.domain.ad401.vo.Ad401VO;

@Service
public class Ad401ServiceImpl implements Ad401Service {

    @Autowired
    private Ad401Mapper ad401Mapper;

    @Override
    public List<Ad401VO> ad401List() {
        return ad401Mapper.ad401List();
    }

    @Override
    public int getAd401Update(Ad401VO avo) {
        return ad401Mapper.getAd401Update(avo);
    }

    @Override
    public int getAd401Delete(int ad401_idx) {
        return ad401Mapper.getAd401Delete(ad401_idx);
    }

    @Override
    public int getAd401Write(Ad401VO avo) {
        return ad401Mapper.getAd401Write(avo);
    }

    @Override
    public Ad401VO getAd401Idx(int ad401_idx) {
        return ad401Mapper.getAd401Idx(ad401_idx);
    }

}
