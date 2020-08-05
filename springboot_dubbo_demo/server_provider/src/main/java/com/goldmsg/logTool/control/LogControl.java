package com.goldmsg.logTool.control;


import com.goldmsg.logTool.mapper.LogMapper;
import com.goldmsg.logTool.mapper.TestMapper;
import com.goldmsg.logTool.service.AutoIdempotent;
import com.goldmsg.logTool.service.TokenService;
import com.goldmsg.logTool.service.impl.LogServiceImpl;
import com.goldmsg.logTool.utils.BaseResults;
import com.goldmsg.logTool.utils.ResultsGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(value = "Log controller", description = "日志控制器")
@RestController
@RequestMapping("/gmvcs/logHandle")
public class LogControl {

    @Autowired
    protected ResultsGenerator resultsGenerator;

    @Autowired
    protected LogMapper logService;


    @Resource
    private TokenService tokenService;
//
//    @Resource
//    private TestService testService;
//    @Autowired
//    LogService logService;

    @ApiOperation(value = "查询日志", notes = "根据参数查出日志信息")
    @RequestMapping(value = "/log/query", method = RequestMethod.GET)
    public BaseResults logSearch() throws Exception {

        //返回查询参数结果
//        List<LogResponse> logResponse = logService.getLogResponse(request);
        Map map = new HashMap();
        logService.getInfos(map);
        BaseResults baseResults = resultsGenerator.success(tokenService.createToken());
//        throw new Exception();

        return baseResults;
    }

    @AutoIdempotent
    @ApiOperation(value = "保存日志", notes = "保存日志信息")
    @RequestMapping(value = "/log/save", method = RequestMethod.GET)
    public BaseResults logSave() throws Exception {

//        System.out.println(request);
//
//
//        //返回保存结果
//        Boolean ret = logService.insertLogInfo(request);

        BaseResults baseResults = null;
//        if(ret){
//            baseResults = resultsGenerator.success("成功保存日志");
//            baseResults.setCode(0);
//        }else{
//            baseResults = resultsGenerator.error();
//        }
        baseResults = resultsGenerator.success("成功保存日志");

        return baseResults;
    }
}