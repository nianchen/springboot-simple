package org.jy.web.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jy.base.model.DataStatistics;
import org.jy.base.service.DataStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/statistics")
@Api(value = "驾培统计数据",description = "在线统计驾培的相关数据汇总")
public class DataStatisticsController {
    @Resource
   private DataStatisticsService dataStatisticsServer;

    @ApiOperation(value = "平台内部统计的数据", notes = "发布接口 ", code = 200, produces = "application/json")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object getAll(){
        List ls = dataStatisticsServer.getStatistics();
        return new PageInfo<DataStatistics>(ls);
    }
}
