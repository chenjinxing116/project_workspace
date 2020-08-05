package com.chen.utils;

import com.chen.ExampleApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SolutionTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("===========================开始测试===========================");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("===========================结束测试===========================");
    }

    //(timeout = 100)
    @Test
    public void letterCombinations() {
        long startTime = System.currentTimeMillis();
        Solution s = new Solution();
        List l = new ArrayList();
        l.add("09");
        l.add("0");
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            input = input.append(l.get(i));
        }
        List<String> ls = s.letterCombinations(input.toString());
        Assert.assertNotNull(ls);
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;
        //输入letterCombinations方法执行时间
        System.out.println("letterCombinations()方法执行时间（单位秒）：" + Float.toString(seconds) + " seconds.");
        System.out.println("输入内容：" + input.toString());
        System.out.println("输出结果:" + ls.toString());
    }


}
