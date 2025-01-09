package com.ict.finalspringboot.domain.phar_info.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ict.finalspringboot.domain.phar_info.vo.pharVO;

@Mapper
public interface PharMapper {

    List<pharVO> pharinfoList();

    // 수정하기
    int pharinfoUpdate(pharVO pvo);

    // 삭제하기
    int getpharDelete(int phar_idx);

    
    pharVO getpharsDetail(int phar_idx);

    // 생성하기
    int pharinfoWrite(pharVO pvo);

}
