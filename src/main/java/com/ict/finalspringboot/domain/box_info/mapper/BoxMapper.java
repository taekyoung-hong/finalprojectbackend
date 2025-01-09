package com.ict.finalspringboot.domain.box_info.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ict.finalspringboot.domain.box_info.vo.BoxVO;

@Mapper
public interface BoxMapper {

    List<BoxVO> BoxinfoList();

    // 수정하기
    int BoxinfoUpdate(BoxVO bvo);

    // 삭제하기
    int BoxinfoDelete(int box_idx);

    
    BoxVO getboxsDetail(int box_idx);

    // 생성하기
    int BoxinfoWrite(BoxVO pvo);

}
