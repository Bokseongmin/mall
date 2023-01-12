package com.mall.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mall.dao.AccountDao;
import com.mall.vo.AccountVo;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	public void signup(AccountVo vo) throws Exception {
		accountDao.signup(vo);
	}

	public AccountVo signin(AccountVo vo) throws Exception {
		return accountDao.signin(vo);
	}

	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}
}