package com.ict.finalspringboot.domain.user_info_tbl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.ict.finalspringboot.domain.user_info_tbl.vo.UserVO;


@Mapper
public interface UserMapper {

    List<UserVO> userList();



}
