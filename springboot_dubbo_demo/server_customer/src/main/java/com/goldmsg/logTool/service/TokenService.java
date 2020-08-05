package com.goldmsg.logTool.service;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    String createToken();
    Boolean checkToken(HttpServletRequest request) throws Exception;;
}
