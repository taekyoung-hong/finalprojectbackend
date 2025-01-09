package com.ict.finalspringboot.domain.phar_info.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pharVO {
    private int phar_idx; // 약국 ID
    private String phar_name; // 약국명
    private String phar_address; // 주소
    private double phar_long; // 경도 (MySQL DOUBLE -> Java double)
    private double phar_lat; // 위도 (MySQL DOUBLE -> Java double)
}
