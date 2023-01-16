package com.mall.service;

import java.util.List;

import com.mall.vo.GoodsViewVo;
import com.mall.vo.ReplyVo;

public interface ShopService {
	
	// 리스트
	public List<GoodsViewVo> list(int cateCode, int level) throws Exception;
	
	// 조회
	public GoodsViewVo view(int gdsNum) throws Exception;
	
	// 리뷰 작성
	public void up(ReplyVo vo) throws Exception;
	
	// 리뷰 목록
	public List<ReplyVo> reply_list(int gdsNum) throws Exception;
}
