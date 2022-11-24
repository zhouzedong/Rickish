package com.rickish.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class VacationDto {
    private String today;//今天星期几
    private String WeekTime;//本周末时间
    private String differWeek; //相差本周末时间
    //private int isVacation; //是否法定节假日假期
    //private int oneday; //相距元旦假期时间
    //private int newyear; //相距春节假期时间
    //private int pureday; //相距清明节假期时间
    //private int mayday; //相距劳动节假期时间
    //private int dragonday; //相距端午节假期时间
    //private int moonday; //相距中秋节假期时间
    //private int nationaday; //相距劳动节假期时间
    private List<LeaveTypeDto> LType;
}
