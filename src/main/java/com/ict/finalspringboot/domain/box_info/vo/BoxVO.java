package com.ict.finalspringboot.domain.box_info.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxVO {
    private int Box_idx; // 약국 ID
    private String Box_name; // 약국명
    private String Box_address; // 주소
    private double Box_long; // 경도 (MySQL DOUBLE -> Java double)
    private double Box_lat; // 위도 (MySQL DOUBLE -> Java double)
}
