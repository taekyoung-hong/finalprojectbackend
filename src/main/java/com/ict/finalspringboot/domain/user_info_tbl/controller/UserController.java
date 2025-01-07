package com.ict.finalspringboot.domain.user_info_tbl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.finalspringboot.domain.auth.vo.DataVO;
import com.ict.finalspringboot.domain.user_info_tbl.service.UserService;
import com.ict.finalspringboot.domain.user_info_tbl.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user_info_tbl")
public class UserController {
   
    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public DataVO userList() {
        DataVO dataVO = new DataVO();
        try {
            List<UserVO> userlist = userService.userList();
            // 리스트가 null일 경우 빈 리스트로 초기화
            if (userlist == null) {
                userlist = new ArrayList<>(); // 빈 리스트로 초기화
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("user 조회 성공");
            dataVO.setData(userlist);

        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("user 조회 실패");
            e.getStackTrace();
        }
        return dataVO;
    }

 
}
