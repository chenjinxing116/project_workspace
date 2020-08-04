package com.chen.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {


    @Test
    public void letterCombinations() {
        Solution s = new Solution();
        List l = new ArrayList();
        l.add("1");
        l.add("0");
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            input = input.append(l.get(i));
        }
        List<String> ls = s.letterCombinations(input.toString());
        System.out.println(input.toString());
        System.out.println(ls.toString());
    }


}
