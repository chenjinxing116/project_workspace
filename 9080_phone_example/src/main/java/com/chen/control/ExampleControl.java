package com.chen.control;

import com.chen.service.ExampleService;
import com.chen.utils.BaseResults;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Example controller", description = "示例控制器")
@RestController
@RequestMapping("/chen/exampleHandle")
public class ExampleControl {

    @Autowired
    ExampleService exampleService;

    @ApiOperation(value = "输入查询接口", notes = "根据参数查出对应手机按钮字符串")
    @RequestMapping(value = "/example/query", method = RequestMethod.GET)
    public BaseResults exampleSearch(@ApiParam(value = "支持从0到99的数字") @RequestParam(value = "arr") List arr) {
        return exampleService.query(arr);
    }

}