package com.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.AdminDao;
import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsVo;

@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao dao;
	
	public List<CategoryVo> category() throws Exception {
		return dao.category();
	}

	public void up(GoodsVo vo) throws Exception {
		dao.up(vo);
	}

	public List<GoodsVo> list() throws Exception {
		return dao.list();
	}

	public GoodsVo view(int gdsNum) throws Exception {
		return dao.view(gdsNum);
	}
}
