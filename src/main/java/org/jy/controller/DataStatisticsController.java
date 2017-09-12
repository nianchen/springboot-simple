package org.jy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jy.base.util.RedisUtil;
import org.jy.base.model.DataStatistics;
import org.jy.base.service.DataStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Api(value = "统计数据", description = "在线统计数据汇总")
public class DataStatisticsController {
    @Resource
    private DataStatisticsService dataStatisticsServer;
    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "内部统计的数据", notes = "发布接口 ", code = 200, produces = "application/json")
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public Object getAll() {
        List ls = dataStatisticsServer.getStatistics();
        return new PageInfo<DataStatistics>(ls);
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public Object getTotal() {
        return dataStatisticsServer.getTotal();
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public Object getRedis() {
        redisUtil.set("foo_boot", "8989898");
        getValueMap(redisUtil.get("gps_1754162213352385"));
        return JSON.toJSON(redisUtil.get("gps_1754162213352385"));
    }


    private Map<String, String> getValueMap(Object obj) {
        Map<String, String> map = new HashMap<>();
        // System.out.println(obj.getClass());
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;

    }
}
