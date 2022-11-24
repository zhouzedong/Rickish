package com.rickish.service.impl;

import com.rickish.entity.Vacation;
import com.rickish.mapper.VacationMapper;
import com.rickish.service.VacationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ken
 * @since 2022-04-24
 */
@Service
public class VacationServiceImpl extends ServiceImpl<VacationMapper, Vacation> implements VacationService {

}
