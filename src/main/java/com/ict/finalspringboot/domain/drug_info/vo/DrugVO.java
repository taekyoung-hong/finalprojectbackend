package com.ict.finalspringboot.domain.drug_info.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugVO {
    private int drung_info_idx; // 약국 ID
    private String item_name; // 약국명
    private String entp_name; // 주소
    private String item_seq; // 주소
    private String chart; // 주소
    private String item_image; // 주소
    private String drug_shape; // 주소
    private String class_name; // 주소
    private String etc_otc_name; // 주소
    
}
