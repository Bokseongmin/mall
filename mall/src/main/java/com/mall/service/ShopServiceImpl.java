package com.mall.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mall.dao.ShopDao;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.ReplyVo;

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

	public GoodsViewVo view(int gdsNum) throws Exception {
		return dao.view(gdsNum);
	}

	public void up(ReplyVo vo) throws Exception {
		dao.up(vo);
	}
	
	public List<ReplyVo> reply_list(int gdsNum) throws Exception {
		return dao.reply_list(gdsNum);
	}
}
