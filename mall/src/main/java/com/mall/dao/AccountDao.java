package com.mall.dao;

import org.springframework.stereotype.Repository;

import com.mall.vo.AccountVo;

@Repository("AccountDao")
public class AccountDao extends CommonDao{
	
	//회원가입
	public void signup(AccountVo vo) throws Exception{
		getSqlSession().insert("mAccount.signup", vo);
	}
	
	//로그인
	public AccountVo signin(AccountVo vo) throws Exception{
		return getSqlSession().selectOne("mAccount.signin", vo);
	}
}
