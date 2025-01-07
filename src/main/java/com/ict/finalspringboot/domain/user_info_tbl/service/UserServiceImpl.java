package com.ict.finalspringboot.domain.user_info_tbl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.finalspringboot.domain.user_info_tbl.mapper.UserMapper;
import com.ict.finalspringboot.domain.user_info_tbl.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> userList() {
    
       List<UserVO> list = userMapper.userList();
        if (list == null) {
            list = new ArrayList<>(); // null일 경우 빈 리스트로 초기화
            System.out.println("데이터가 없습니다.");
        }
        return list;
    }

   
}
