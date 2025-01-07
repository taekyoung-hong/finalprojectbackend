package com.ict.finalspringboot.domain.ad401.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad401VO {
    private String ad401_idx;
    private String ad401title; // 약국 ID
    private String ad401content; // 약국명
    private String ad401_subtitle1; // 주소
    private double ad401_subcontent1; // 경도 (MySQL DOUBLE -> Java double)
    private String ad401_subtitle2; // 주소
    private double ad401_subcontent2; // 경도 (MySQL DOUBLE -> Java double)
    private String ad401_subtitle3; // 주소
    private double ad401_subcontent3; // 경도 (MySQL DOUBLE -> Java double)
 
}
