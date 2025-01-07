package com.ict.finalspringboot.domain.user_info_tbl.service;

import java.util.List;

import com.ict.finalspringboot.domain.user_info_tbl.vo.UserVO;



public interface UserService {

    // 조회 불러오기
    List<UserVO> userList();


}