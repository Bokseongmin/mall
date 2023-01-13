package com.mall.service;

import java.util.List;

import com.mall.vo.CategoryVo;

public interface AdminService {
	
	//카테고리
	public List<CategoryVo> category() throws Exception;
}
