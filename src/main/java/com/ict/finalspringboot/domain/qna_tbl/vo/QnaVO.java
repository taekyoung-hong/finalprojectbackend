package com.ict.finalspringboot.domain.qna_tbl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaVO {
    private String qna_title; 
    private String qna_question; 
    private String qna_q_reg_date; 
    private String phar_answer; 
    private String phar_a_reg_date; 
    private int user_idx; 
}