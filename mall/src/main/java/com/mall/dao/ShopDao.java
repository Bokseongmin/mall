package com.mall.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.GoodsViewVo;

@Repository("ShopDao")
public class ShopDao extends CommonDao{
	
	// 목록 1차
	public List<GoodsViewVo> list(int cateCode, int cateCodeRef) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return getSqlSession().selectList("mShop.list_1", map);
	}
	
	// 목록 2차
	public List<GoodsViewVo> list(int cateCode) throws Exception {
		return getSqlSession().selectList("mShop.list_2", cateCode);
	}
}
