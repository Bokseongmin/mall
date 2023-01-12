package com.mall.service;

import javax.servlet.http.HttpSession;

import com.mall.vo.AccountVo;

public interface AccountService {
	
	//회원가입
	public void signup(AccountVo vo) throws Exception;
	
	//로그인
	public AccountVo signin(AccountVo vo) throws Exception;
	
	//로그아웃
	public void signout(HttpSession session) throws Exception;
}
