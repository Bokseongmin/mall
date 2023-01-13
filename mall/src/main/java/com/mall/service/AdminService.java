package com.mall.service;

import java.util.List;

import com.mall.vo.CategoryVo;
import com.mall.vo.GoodsVo;

public interface AdminService {
	
	//카테고리
	public List<CategoryVo> category() throws Exception;
	
	//상품 등록
	public void up(GoodsVo vo) throws Exception;
}
