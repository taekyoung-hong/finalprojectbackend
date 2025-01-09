package com.ict.finalspringboot.domain.popup.vo;

import lombok.Data;

@Data
public class PopupVO {
    private String fileName;
    private String division;
    private String time;
    private String startDate;
    private String endDate;
    private int top;
    private int left;
    private String title;
    private String content;
}
