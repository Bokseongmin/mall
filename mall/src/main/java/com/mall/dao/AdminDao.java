package com.mall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsVo;

@Repository("AdminDao")
public class AdminDao extends CommonDao{
	
	//카테고리 조회
	public List<CategoryVo> category() throws Exception {
		return getSqlSession().selectList("mAdmin.category");
	}
	
	//상품 등록
	public void up(GoodsVo vo) throws Exception {
		getSqlSession().insert("mAdmin.up", vo);
	}
}
