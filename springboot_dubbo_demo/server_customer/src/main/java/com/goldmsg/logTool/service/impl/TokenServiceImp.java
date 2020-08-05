package com.goldmsg.logTool.service.impl;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.goldmsg.logTool.service.RedisService;
import com.goldmsg.logTool.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

@Component
public class TokenServiceImp implements TokenService {
    @Autowired
    private RedisService redisService;

    @Override
    public String createToken() {
        String str = RandomUtil.randomUUID();
        StrBuilder token = new StrBuilder();
        try {
            token.append("TokenCJX").append(str);
            redisService.setEx(token.toString(), token.toString(),10000L);
            boolean notEmpty = StrUtil.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader("TokenCJX");
        if (StrUtil.isBlank(token)) {// header中不存在token
            token = request.getParameter("TokenCJX");
            if (StrUtil.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException("参数Token不存在异常");
            }
        }

        if (!redisService.exists(token)) {
            throw new ServiceException("redis中Token不存在异常!");
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new ServiceException("token删除异常");
        }
        return true;
    }
}
