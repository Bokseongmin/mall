package com.mall.service;

import java.util.List;

import com.mall.vo.CartVo;
import com.mall.vo.GoodsViewVo;
import com.mall.vo.GoodsVo;
import com.mall.vo.OrderDetailVo;
import com.mall.vo.OrderListVo;
import com.mall.vo.OrderVo;
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
	
	// 리뷰 수정
	public void reply_modify(ReplyVo vo) throws Exception;
	
	// 리뷰 삭제
	public void reply_delete(ReplyVo vo) throws Exception;
	
	// 리뷰 삭제 아이디 확인
	public String idCheck(int repNum) throws Exception;
	
	// 상품 담기
	public void cart_add(CartVo vo) throws Exception;

	// 카트 리스트
	public List<CartVo> cart_List(String userId) throws Exception;
	
	// 카트 삭제
	public void cart_delete(CartVo vo) throws Exception;
	
	// 주문 정보
	public void order_info(OrderVo vo) throws Exception;
	
	// 주문 상세 정보
	public void order_detail_info(OrderDetailVo vo) throws Exception;
	
	// 카트 비우기
	public void delete_all(String userId) throws Exception;
	
	// 주문 목록
	public List<OrderVo> order_list(OrderVo vo) throws Exception;
	
	// 특정 주문 목록
	public List<OrderListVo> order_view(OrderVo vo) throws Exception;
	
}
