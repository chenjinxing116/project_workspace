package com.chen.service.impl;

import com.chen.service.ExampleService;
import com.chen.utils.BaseResults;
import com.chen.utils.Solution;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImp extends ExampleService {


    @Override
    public BaseResults<String> query(List arr) {
        Solution solution = new Solution();
        BaseResults results = new BaseResults();
        if (arr != null) {
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                input = input.append(arr.get(i));
            }
            //0~99的数字
            int a = 0;
            try {
                a = Integer.parseInt(input.toString());
                if (input.length() > 2) {
                    throw new Exception();
                }
            } catch (Exception e) {
                results.setCode(-1);
                results.setData(input.toString());
                results.setMsg("支持从0到99的数字！请输入正确内容");
                return results;
            }
            if (a > 99 || a < 0) {
                results.setCode(-2);
                results.setData(input.toString());
                results.setMsg("超出0~99范围！");
                return results;
            }
            List<String> ls = solution.letterCombinations(input.toString());
            results.setCode(0);
            results.setMsg(arr.toString());
            results.setData(ls.toString());
        }
        return results;
    }


}
