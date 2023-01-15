package com.mall.service;

import java.util.List;

import com.mall.vo.GoodsViewVo;

public interface ShopService {
	
	// 리스트
	public List<GoodsViewVo> list(int cateCode, int level) throws Exception;
}
