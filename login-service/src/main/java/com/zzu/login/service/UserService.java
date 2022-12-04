package com.zzu.login.service;



import com.zzu.generalApi.pojo.User;
import com.zzu.generalApi.vo.RespBean;
import com.zzu.login.vo.LoginVO;
import com.zzu.login.vo.RegisterVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    RespBean login(LoginVO loginVO, HttpServletRequest request, HttpServletResponse response);
    RespBean register(RegisterVO registerVO);
    User getUserByTicket(String ticket, HttpServletRequest request, HttpServletResponse response);
}
