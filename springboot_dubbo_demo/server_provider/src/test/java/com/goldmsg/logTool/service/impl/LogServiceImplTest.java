package com.goldmsg.logTool.service.impl;

import com.goldmsg.logTool.service.LogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class LogServiceImplTest {

    @Autowired
    LogService logService;

    @Test
    public void getLogInfos() {
        Map map = new HashMap();
        logService.getLogInfos(map);
    }
}