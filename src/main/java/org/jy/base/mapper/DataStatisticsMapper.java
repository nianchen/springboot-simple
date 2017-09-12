package org.jy.base.mapper;

import org.jy.base.model.DataStatistics;
import org.jy.base.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStatisticsMapper extends MyMapper<DataStatistics> {
    Integer getTotal();
}