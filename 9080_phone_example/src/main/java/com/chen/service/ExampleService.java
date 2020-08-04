package com.chen.service;

import com.chen.utils.BaseResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ExampleService {
    /**
     * 编辑保存系统
     *
     * @param arr 输入内容
     * @return
     */
    public abstract BaseResults<String> query(List arr);
}
