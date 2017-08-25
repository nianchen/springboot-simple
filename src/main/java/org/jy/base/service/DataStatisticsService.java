package org.jy.base.service;

import com.github.pagehelper.PageHelper;
import org.jy.base.mapper.DataStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStatisticsService {

    @Autowired    private DataStatisticsMapper dataStatisticsMapper;

    public List getStatistics(){
        PageHelper.startPage(249,10);
        return dataStatisticsMapper.selectAll();
    }
}
