package com.ict.finalspringboot.domain.notice.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
    private int notice_idx; 
    private String notice_content; 
    private String notice_title; 
    private String notice_reg_date; 
    private String notice_file_name; 
    private String notice_delete; 
    private String notice_out_date; 
    private String notice_file;  // 변경
    
    
}