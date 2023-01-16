package com.mall.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.GoodsViewVo;
import com.mall.vo.ReplyVo;

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
	
	public GoodsViewVo view(int gdsNum) throws Exception {
		return getSqlSession().selectOne("mShop.view", gdsNum);
	}
	
	// 리뷰 작성
	public void up(ReplyVo vo) throws Exception {
		getSqlSession().insert("mShop.up", vo);
	}
	
	
	// 리뷰 목록
	public List<ReplyVo> reply_list(int gdsNum) throws Exception {
		return getSqlSession().selectList("mShop.reply_list", gdsNum);
	}
	
	// 리뷰 수정
	public void reply_modify(ReplyVo vo) throws Exception {
		getSqlSession().update("mShop.reply_modify", vo);
	}
	
	// 리뷰 삭제
	public void reply_delete(ReplyVo vo) throws Exception {
		getSqlSession().delete("mShop.reply_delete", vo);
	}
	
	// 리뷰 삭제 아이디 확인
	public String idCheck(int repNum) throws Exception {
		return getSqlSession().selectOne("mShop.reply_idCheck", repNum);
	}
}
