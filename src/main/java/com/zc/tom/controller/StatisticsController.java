package com.zc.tom.controller;

import com.zc.tom.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：WangYi
 * @date ：Created in 2019/4/24 11:22
 * @description：
 * @modified By：
 */
@Api(tags = "统计")
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @ApiOperation(value = "工资统计下载(班级为单位)，本接口查询上一月整月工资", httpMethod = "GET", produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/statistics/{classUUID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<InputStreamResource> statistics(@PathVariable("classUUID") String classUUID) {
        return statisticsService.statistics(classUUID);
    }

    @ApiOperation(value = "工资统计前，检查哪一个学生没有给考核分数（上一月）")
    @GetMapping("/checkIn/{classUUID}")
    List<String> checkIn(@PathVariable("classUUID") String classUUID){
        return statisticsService.checkIn(classUUID);
    }
}
