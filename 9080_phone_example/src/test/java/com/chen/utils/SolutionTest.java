package com.chen.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

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
        System.out.println(input.toString());
        System.out.println(ls.toString());
    }


}
