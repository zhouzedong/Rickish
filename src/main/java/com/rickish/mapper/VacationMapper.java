package com.rickish.mapper;

import com.rickish.entity.Vacation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ken
 * @since 2022-04-24
 */
@Repository
public interface VacationMapper extends BaseMapper<Vacation> {
     List<Vacation> getAllVacation(@Param("todaydate")String todaydate);
}
