package com.ict.finalspringboot.domain.drug_info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.drug_info.mapper.DrugMapper;
import com.ict.finalspringboot.domain.drug_info.vo.DrugVO;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<DrugVO> druginfoList() {
        List<DrugVO> list = drugMapper.druginfoList();
        if (list == null) {
            list = new ArrayList<>(); // null일 경우 빈 리스트로 초기화
            System.out.println("데이터가 없습니다.");
        }
        return list;
    }

    @Override
    public int druginfoWrite(DrugVO dvo) {

        return drugMapper.druginfoWrite(dvo); // Mapper 호출
    }

    @Override
    public DrugVO getdrugsDetail(int drug_idx) {
        DrugVO list = drugMapper.getdrugsDetail(drug_idx);
        if (list == null) {
            // null일 경우 빈 리스트로 초기화
            System.out.println("데이터가 없습니다.");
        }
        return list;
    }

    @Override
    public int druginfoDelete(int drug_idx) {
        return drugMapper.druginfoDelete(drug_idx);
    }

    @Override
    public int druginfoUpdate(DrugVO dvo) {

        return drugMapper.druginfoUpdate(dvo);
    }
}