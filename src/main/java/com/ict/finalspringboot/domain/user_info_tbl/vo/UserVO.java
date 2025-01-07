package com.ict.finalspringboot.domain.user_info_tbl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private int user_idx;
    private String user_id;
    private int user_level_idx;
    private String user_pw;
    private String user_profile;
    private String user_reg_date;
    private String user_name;
    private String user_nickname;
    private String user_kakao;
    private String user_naver;
    private String user_google;
    private String user_birth_data;
    private String user_gender;
    private String user_email;
    private String user_phone;
    private String admin_idx;
    private String user_out_data;
    private String user_last_login;
    private String user_out_reason;

}