package com.ict.finalspringboot.domain.drug_side_effect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.drug_side_effect.mapper.DSEMapper;
import com.ict.finalspringboot.domain.drug_side_effect.vo.DSEVO;

@Service
public class DrugSideEffectServiceImpl implements DrugSideEffectService {

    @Autowired
    private DSEMapper dseMapper;

    @Override
    public List<DSEVO> dSEinfoList() {
        List<DSEVO> list = dseMapper.dSEinfoList();
        if (list == null) {
            list = new ArrayList<>(); // null일 경우 빈 리스트로 초기화
            System.out.println("데이터가 없습니다.");
        }
        return list;
    }

    @Override
    public int dSEinfoWrite(DSEVO dvo) {

        return dseMapper.dSEinfoWrite(dvo); // Mapper 호출
    }

    @Override
    public int dSEinfoDelete(int drug_side_effect_idx) {
        return dseMapper.dSEinfoDelete(drug_side_effect_idx);
    }

    @Override
    public int dSEinfoUpdate(DSEVO dvo) {

        return dseMapper.dSEinfoUpdate(dvo);
    }

  

    @Override
    public DSEVO getdSEDetail(int drug_side_effect_idx) {
        return dseMapper.getdSEDetail(drug_side_effect_idx);
    }

}