package com.ict.finalspringboot.domain.drug_side_effect.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DSEVO {
    private int drung_info_idx; // 약국 ID
    private String ingredient_name; // 약국명
    private String ingredient_code; // 주소
    private String product_code; // 주소
    private String product_name; // 주소
    private String side_detail; // 주소
    private String company_name; // 주소
    private String data_source; // 주소

}
