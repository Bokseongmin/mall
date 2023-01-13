package com.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.AdminDao;
import com.mall.vo.CategoryVo;

@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao dao;
	
	public List<CategoryVo> category() throws Exception {
		return dao.category();
	}
}
