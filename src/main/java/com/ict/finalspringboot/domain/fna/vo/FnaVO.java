package com.ict.finalspringboot.domain.fna.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FnaVO {
  
    private int fna_idx;             // FNA ID
    private int admin_idx;           // 관리자의 ID (admin 테이블의 외래 키)
    private String fna_question;     // 질문 내용
    private String fna_answer;       // 답변 내용
    private Date fna_reg_date;        // 질문 등록일
    private Date fna_up_date;         // 답변 업데이트일
    private int fna_delete;          // 삭제 여부
    private Date fna_out_date;        // 답변 삭제일
}