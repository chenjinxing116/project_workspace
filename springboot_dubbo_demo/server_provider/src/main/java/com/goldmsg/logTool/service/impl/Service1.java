package com.goldmsg.logTool.service.impl;

import com.goldmsg.logTool.service.SPIService;

public class Service1 implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPI服务发现机制：打印服务1111111111");
    }
}
