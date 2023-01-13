package com.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.CategoryVo;

@Repository("AdminDao")
public class AdminDao extends CommonDao{
	public List<CategoryVo> category() throws Exception {
		return getSqlSession().selectList("mAdmin.category");
	}
}
