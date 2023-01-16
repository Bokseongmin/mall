package com.mall.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.vo.CartVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.OrderDetailVo;
import com.mall.vo.OrderListVo;
import com.mall.vo.OrderVo;
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
	
	// 카트 담기
	public void cart_add(CartVo vo) throws Exception {
		getSqlSession().insert("mShop.cart_add", vo);
	}
	
	// 카트 목록
	public List<CartVo> cart_list(String userId) throws Exception {
		return getSqlSession().selectList("mShop.cart_list", userId);
	}
	
	// 카트 삭제
	public void cart_delete(CartVo vo) throws Exception {
		getSqlSession().delete("mShop.cart_delete", vo);
	}
	
	// 주문 정보
	public void order_info(OrderVo vo) throws Exception {
		getSqlSession().insert("mShop.order_info", vo);
	}
	
	// 주문 상세 정보
	public void order_detail_info(OrderDetailVo vo) throws Exception {
		getSqlSession().insert("mShop.order_detail_info", vo);
	}
	
	// 카트 비우기
	public void delete_all(String userId) throws Exception {
		getSqlSession().delete("mShop.delete_all", userId);
	}
	
	// 주문 목록
	public List<OrderVo> order_list(OrderVo vo) throws Exception {
		return getSqlSession().selectList("mShop.order_list", vo);
	}
	
	// 특정 주문 목록
	public List<OrderListVo> order_view(OrderVo vo) throws Exception {
		return getSqlSession().selectList("mShop.order_view", vo);
	}
}
