package com.mall.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mall.vo.AccountVo;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		HttpSession session = req.getSession();
		AccountVo vo = (AccountVo)session.getAttribute("account");
		
		if(vo == null || vo.getVerify() != 9) {
			res.sendRedirect("/sign/in");
			return false;
		}
		return true;
	}
}
