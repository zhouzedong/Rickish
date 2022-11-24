package com.rickish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ken
 * @since 2022-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Vacation implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 假期名称
     */
    private String name;

    private LocalDate vacaDate;

    /**
     * 假期开始日期字符串
     */
    private String datetxtStart;

    /**
     * 假期期间日期字符串
     */
    private String datetxtDuring;

    /**
     * 假期天数
     */
    private Integer holiday;

    /**
     * 是否调休
     */
    private String isrevise;

    /**
     * 调休日期1
     */
    private String revise1;

    /**
     * 调休日期2
     */
    private String revise2;

    /**
     * 调休日期3
     */
    private String revise3;

    /**
     * 调休日期4
     */
    private String revise4;

    /**
     * 记录修改时间
     */
    private LocalDateTime updatetime;

    private String datetxtEnd;


}
