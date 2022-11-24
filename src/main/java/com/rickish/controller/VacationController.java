package com.rickish.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rickish.entity.Vacation;
import com.rickish.entity.dto.LeaveTypeDto;
import com.rickish.entity.dto.VacationDto;
import com.rickish.mapper.VacationMapper;
import com.rickish.utils.GetVacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Ken
 * @since 2022-04-24
 */
@RestController
@RequestMapping("/vacation")
public class VacationController {
    @Autowired
    private VacationMapper vacationMapper;

    @GetMapping
    public String getLeave() throws ParseException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        String during_txt ="";
        int a = Integer.parseInt(str);
        if (a >= 0 && a <= 6) {
            during_txt = "凌晨";
        }
        if (a > 6 && a <= 12) {
            during_txt = "上午";
        }
        if (a > 12 && a <= 13) {
            during_txt = "中午";
        }
        if (a > 13 && a <= 18) {
            during_txt = "下午";
        }
        if (a > 18 && a <= 24) {
            during_txt = "晚上";
        }

        GetVacation getVacation = new GetVacation();
        Map<String, String> getdatemap = getVacation.getSaturday();
        //今天的日期，入参查询
        String today_value = getdatemap.get("today");
        String whatday = getdatemap.get("whatday");
        String Saturday = getdatemap.get("Saturday");
        String Sunday = getdatemap.get("Sunday");
        String isweek = getdatemap.get("isweek");
        String dayGap = getdatemap.get("dayGap");
        System.out.println(today_value + whatday + Saturday);
        VacationDto vacationDto = new VacationDto();
        vacationDto.setToday(today_value);
        QueryWrapper<Object> QueryWrapper = new QueryWrapper<>();
        List<Vacation> vacations = vacationMapper.getAllVacation("2022-05-03");
        List<LeaveTypeDto> leaveTypeDtolist = new ArrayList<>();
        System.out.println("断点3");
        System.out.println("原始："+vacations);
        String result = during_txt +"好，打工人" + "\n" + "今天是" + ((today_value.replaceFirst("-", "年")).replaceFirst("-", "月")) + "日," + whatday + "\n"
                + "工作再累，一定不要忘记摸鱼哦！有事没事起身去茶水间，去厕所，去廊道走走，别老在工位上坐着，钱是老板的,但命是自己的。" + "\n";
        //今天是04月27日周三
        if (vacations.size() > 0) {
            //封装节假日
            int isVavation = Integer.parseInt(isweek);
            for (int i = 0; i < vacations.size(); i++) {
                LeaveTypeDto leaveTypeDto = new LeaveTypeDto();
                leaveTypeDto.setType_id(vacations.get(i).getId());
                leaveTypeDto.setType_name(vacations.get(i).getName());
                String dayGap_value = getVacation.getDayGap(today_value, vacations.get(i).getDatetxtStart());
                leaveTypeDto.setType_differ(dayGap_value);
                //查找今天属于那个假期
                System.out.println("假期判断"+vacations.get(i).getDatetxtEnd());
                if((vacations.get(i).getDatetxtDuring()).contains(today_value)){
                    result =result+ "今天是"+vacations.get(i).getName()+"，假日期间！";
                }else {
                    //不是假期，判断是否周末
                    //result += isweek.equals("1") ? "" : "距离周末还有" + dayGap + "天";
                    if(isweek=="1"&&i==1){
                        result +=  "距离周末还有" + dayGap + "天";
                    }
                }
                if (dayGap_value.contains("-")){

                }else{
                    result += "\n" + "距离" + vacations.get(i).getName() + "还有" + dayGap_value + "天";
                }

                //System.out.println(it.next());
                vacationDto.setToday(today_value);
                vacationDto.setWeekTime(Saturday);//本周末时间
                vacationDto.setDifferWeek(dayGap);
                leaveTypeDtolist.add(leaveTypeDto);
                vacationDto.setLType(leaveTypeDtolist);
            }
            System.out.println(result);
        }
        return result;
    }
}