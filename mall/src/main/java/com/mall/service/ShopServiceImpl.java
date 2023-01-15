package com.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.ShopDao;
import com.mall.vo.GoodsViewVo;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Resource
	private ShopDao dao;

	public List<GoodsViewVo> list(int cateCode, int level) throws Exception {
		
		int cateCodeRef = 0;
		
		if(level==1) {
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else { //2차 분류
			return dao.list(cateCode);
		}
	}
}
