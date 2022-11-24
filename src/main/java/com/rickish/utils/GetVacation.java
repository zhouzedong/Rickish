package com.rickish.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.rickish.entity.Vacation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetVacation {
    public static void main(String[] args) throws ParseException {
        GetVacation vacation = new GetVacation();
        Map<String,String> map = vacation.getSaturday();
        System.out.println(map);
    }
    /**
     * 今天，周六，周日，相差天数
     * 获取周六
     */

    public Map<String,String> getSaturday() throws ParseException {
        Map<String,String> map = new HashMap<>();
        Vacation vacation = new Vacation();
        //当前日期字符串，格式：yyyy-MM-dd,获取本周周末时间
        String today= DateUtil.today();
        System.out.println("今天的日期是"+today);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar=Calendar.getInstance();
        System.out.println("今天是"+weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1]);
        String whatday =weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        //设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        //获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(dayWeek==1){
            dayWeek = 8;
        }
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
//        System.out.println("所在周星期一的日期：" + weekBegin);

        cal.add(Calendar.DATE, 3 +cal.getFirstDayOfWeek());
        Date Saturday = cal.getTime();
        String weekCEnd = sdf.format(Saturday);
        System.out.println("所在周星期六的日期：" + weekCEnd);


        Date Sunday =  DateUtil.offset(Saturday, DateField.DAY_OF_MONTH, 1);
        String weekEnd = DateUtil.formatDate(Sunday);
        System.out.println("所在周星期日的日期：" + weekEnd);
        //进入判断
        if(today.equals(weekCEnd) || today.equals(weekEnd)){
            System.out.println("今天是周末");
            //今天是周末
            String dayGap = getDayGap(today, weekCEnd);
            map.put("today",today);//今天日期
            map.put("isweek","1");//今天是否周末  1，是
            map.put("whatday",whatday);//今天周几
            map.put("Saturday",weekCEnd);//
            map.put("Sunday",weekEnd);//周六
            map.put("dayGap","0");//与周末相差天数
        }else{
            //今天不是周末，与周六相减
            String dayGap = getDayGap(today, weekCEnd);
            map.put("today",today);//今天日期
            map.put("isweek","1");//今天是否周末 2，不是
            map.put("whatday",whatday);//今天周几
            map.put("Saturday",weekCEnd);//周六
            map.put("Sunday",weekEnd);//周日
            map.put("dayGap",dayGap);//与周末相差天数
        }
        System.out.println("map对象"+map);
        return  map;
    }

    //根据日期取得星期几
    public static String getWeek(Date date){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }
//    日期的相差计算
    public String getDayGap(String start_Date,String end_Date) throws ParseException {
        //System.out.println("入参，开始："+start_Date+"结束："+end_Date);
        // 日期格式化
        DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleFormat.parse(start_Date);
        Date endDate = simpleFormat.parse(end_Date);
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        int days = (int) ((endTime - startTime) / (1000 * 60 * 60 * 24));
        String day = String.valueOf(days);
        return day;
    }

}
