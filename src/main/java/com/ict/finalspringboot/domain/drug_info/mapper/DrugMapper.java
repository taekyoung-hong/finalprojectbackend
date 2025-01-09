package com.ict.finalspringboot.domain.drug_info.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ict.finalspringboot.domain.drug_info.vo.DrugVO;

@Mapper
public interface DrugMapper {

    List<DrugVO> druginfoList();

    // 수정하기
    int druginfoUpdate(DrugVO pvo);

    // 삭제하기
    int druginfoDelete(int drug_idx);

    
    DrugVO getdrugsDetail(int drug_idx);

    // 생성하기
    int druginfoWrite(DrugVO pvo);

}
