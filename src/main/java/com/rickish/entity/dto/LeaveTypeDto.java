package com.rickish.entity.dto;

import lombok.Data;

@Data
public class LeaveTypeDto {
    private int type_id;
    private String type_name;   //假期名称
    private String type_differ;//相差天数
}
